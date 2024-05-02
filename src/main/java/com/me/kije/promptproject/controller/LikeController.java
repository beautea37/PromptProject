package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Service.PromptService;
import com.me.kije.promptproject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final PromptService promptService;
    private final UserService userService;

//    @PostMapping("/like/{id}")
//    public Prompt plusLike(@PathVariable Long id, Model model) {
//
//        Prompt prompt = promptService.findById(id);
//
//        model.getAttribute("prompt");
//
//    }

}
