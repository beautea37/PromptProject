package com.me.kije.promptproject.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CommentController {

    @GetMapping("/comments")
    public String comment() {
        return "pages/user/test/sign-up";
    }
}
