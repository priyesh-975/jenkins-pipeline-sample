package com.example.springsecurity.service;

import com.example.springsecurity.model.Registration;
import com.example.springsecurity.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public Registration registerUser(Registration registration)
    {
        return this.registrationRepository.save(registration);
    }
    public Registration getUserDetails(String username) {
        return this.registrationRepository.findByUsername(username);
    }
}
