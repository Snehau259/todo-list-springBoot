package com.example.udemyin28minutes.springBootMaven.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @RequestMapping(value="login",method = RequestMethod.GET)
    public String goToLoginPage() {
        return "LoginController";
    }

    @RequestMapping(value="login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name",name);
        return "Welcome";
    }
}
