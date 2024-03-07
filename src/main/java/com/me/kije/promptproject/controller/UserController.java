package com.me.kije.promptproject.controller;


import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/signin")
    public String signIn() {
        return "pages/user/sign-in";
    }

//    @PostMapping("/signin")
//    public String signIn(@RequestParam String params) {
//        return "redirect/:";
//    }

    @GetMapping("/login")
    public String login() {
        return "pages/user/login";
    }

}
