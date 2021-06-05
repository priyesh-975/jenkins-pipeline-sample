package com.example.springsecurity.controller;

import com.example.springsecurity.model.AuthenticInputs;
import com.example.springsecurity.model.AuthenticateOutput;
import com.example.springsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthentication(@RequestBody AuthenticInputs authenticInputs) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticInputs.getUserName(),authenticInputs.getPassword()));
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect UserName or password",e);
        }

        //creating the token
       final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticInputs.getUserName());

        final String jwtToken=jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticateOutput(jwtToken));

    }
}
