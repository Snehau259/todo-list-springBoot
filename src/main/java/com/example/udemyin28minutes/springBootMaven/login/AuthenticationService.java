package com.example.udemyin28minutes.springBootMaven.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username,String password)
    {
        boolean isValidUsername=username.equalsIgnoreCase("sneha");
        boolean isValidPassword=password.equalsIgnoreCase("sneha");

        return isValidPassword&&isValidPassword;
    }
}
