package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.Service.CommentService;
import com.me.kije.promptproject.Service.PromptService;
import com.me.kije.promptproject.Service.UserDetailService;
import com.me.kije.promptproject.Service.UserService;
import com.me.kije.promptproject.dto.*;
import com.me.kije.promptproject.repository.UserRepository;
import groovyjarjarantlr4.v4.codegen.model.AddToLabelList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

@Controller
//@RestController
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;
    private final UserService userService;
    private final CommentService commentService;

    //메인 페이지
//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String mainPage(Model model) {
        List<PromptViewResponse> prompts = promptService.findAll()
                .stream()
                .map(PromptViewResponse::new)
                .toList();


        model.addAttribute("prompts", prompts);

        return "pages/index";
    }

    //글 작성
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/save")
    public String createPrompt(/*RequestParam(required = false) Long id,*/ Model model) {

        Prompt prompt = new Prompt();

//        if (id == null) {
//            model.addAttribute("prompt", new PromptViewResponse(prompt));
//        } else {
//            model.addAttribute("prompt", new PromptViewResponse(prompt));
//        }
        model.addAttribute("prompt", new PromptViewResponse(prompt));

        return "pages/prompt/prompt";
    }

    // 글 저장
    @PostMapping("/save")
    public ResponseEntity<Prompt> addPrompt(@RequestBody AddPromptRequest request, Principal principal) throws DataFormatException {


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////        User username = userDetailService.loadUserByUsername(principal.getName());
//        User username = userDetailService.loadUserByUsername(String.valueOf(request.getAuthor()));
//
////        System.out.println("Controller username : " + username);
//        System.out.println("Controller.req.getTitle : " + request.getTitle());
//        System.out.println("Controller.req.getSubTitle : " + request.getSubTitle());
//        System.out.println("Controller.req.getContent : " + request.getContent());
//        System.out.println("Controller.req.getAuthor : " + request.getAuthor());
//        System.out.println("Controller.username : !!!!!!!!!!!!!!!!!!! " + username);
//
////        User user = this.userService.getUser(principal.getName());
//
//
//        Prompt savedPrompt = promptService.save(request, String.valueOf(username));
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Prompt savedPrompt = promptService.save(request, principal.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPrompt);
    }


    //    글 조회`
//    @PreAuthorize("isAuthenticated()")
    @GetMapping("/prompt/{id}")
    public String getPromptById(@PathVariable(name = "id") Long id, Model model) throws DataFormatException {
        Prompt prompt = promptService.findById(id);

        User user = userService.getUser(prompt.getAuthor());

        List<CommentResponse> comments = commentService.getComment(id)
                .stream()
                .map(CommentResponse::new)
                .toList();


        model.addAttribute("prompt", new PromptViewResponse(prompt));
        model.addAttribute("user", new UserResponse(user));
        model.addAttribute("comments", comments);

        return "pages/prompt/promptDetail";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrompt(@PathVariable(name = "id") Long id) {
        promptService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/modify/{id}")
    public String newPrompt(@PathVariable("id") Long id, Model model) {
        Prompt prompt = promptService.findById(id);
        if (id == null) {
            model.addAttribute("prompt", new PromptViewResponse(prompt));
        } else {
            model.addAttribute("prompt", new PromptViewResponse(prompt));
        }

        return "pages/prompt/prompt";
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Void> modifyPrompt(@PathVariable(name = "id") Long id, @RequestBody UpdatePromptRequest request) {

        Prompt modifyPrompt = promptService.modify(id, request);

        return ResponseEntity.ok().build();
    }


    public String main(Prompt prompt) {

        return "spring.datasource.driver-class-name";
    }
}