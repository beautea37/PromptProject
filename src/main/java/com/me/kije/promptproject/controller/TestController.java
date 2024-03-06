package com.me.kije.promptproject.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController {

    @GetMapping("/test")
    public String selectImageList(Model model) {
        model.addAttribute("title", "");
        return "index";
    }

}