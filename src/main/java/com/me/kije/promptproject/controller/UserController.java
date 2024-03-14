package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.Service.UserService;
import com.me.kije.promptproject.dto.UserRequest;
import com.me.kije.promptproject.dto.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/sign-up")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("users", new UserResponse(user));

        return "pages/user/test/sign-up";
    }


    @PostMapping("/sign-up")
    public String registerUser(UserRequest user) {
        userService.save(user);
        return "redirect:/"; // Assuming you have a login page to redirect to after signup
    }

    @GetMapping("/login")
    public String login(Model model) {

        User user = new User();

        model.addAttribute("users", new UserResponse(user));

        return "pages/user/test/login";
    }

//    @PostMapping("/login")
//    public ResponseEntity<User> login(@RequestBody UserRequest request) {
//
//
//    }

}

//    회원가입 POST
//    @PostMapping("/sign-up")
//    public String signUpUser(UserRequest request) {
//        userService.save(request);
//        return "redirect:/pages/user/login"; // Assuming you have a login page to redirect to after signup
//    }

//    @PostMapping("/sign-up")
//    public String signup(@Valid UserCreateForm userCreateForm, UserRequest dto, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            return "pages/user/test/sign-up";
//        }
//
//        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
//            bindingResult.rejectValue("password2", "passwordIncorrect", "비밀번호가 일치하지 않습니다.");
//            return "pages/user/test/sign-up";
//        }
//
//        userService.save(dto.getUserName(), dto.getNickName(), dto.getPassword(), dto.getEmail());
//       userService.save()
//        return "redirect:/";
//    }
//

//
//
//    @PostMapping("/login")
//    public String login(@RequestBody UserRequest user) {
//
//        userService.save(user);
//
//        return "redirect:/";
//    }
//
//    //로그아웃 메서드
//    @GetMapping("logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
//
//        return "redirect:/";
//    }

