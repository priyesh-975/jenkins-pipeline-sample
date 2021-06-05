package com.example.springsecurity.controller;

import com.example.springsecurity.model.Registration;
import com.example.springsecurity.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Registration registration)
    {
       this.registrationService.registerUser(registration);
       return new ResponseEntity<Registration>(HttpStatus.OK);
    }
}
