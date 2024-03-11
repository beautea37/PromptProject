package com.me.kije.promptproject.controller;


import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.Service.UserService;
import com.me.kije.promptproject.dto.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "pages/user/sign-up";
    }


    @PostMapping("/sign-up")
    public String registerUser(User user) {
        userService.save(user);
        return "redirect:/"; // Assuming you have a login page to redirect to after signup
    }

    @GetMapping("/login")
    public String login() {
        return "pages/user/login";
    }

}
