package com.example.springsecurity.model;

public class AuthenticateOutput {

    private  String jwtToken;

    public AuthenticateOutput(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    AuthenticateOutput(){

    }
}
