package com.example.springsecurity.service;

import com.example.springsecurity.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
   private RegistrationService registrationService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Registration registration=registrationService.getUserDetails(username);


        return new User(registration.getUsername(),registration.getPassword(),new ArrayList<>());
        //return new User("username","password",new ArrayList<>());
    }
}
