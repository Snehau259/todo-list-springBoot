package com.example.udemyin28minutes.springBootMaven.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage() {
        return "Welcome";
    }
}


