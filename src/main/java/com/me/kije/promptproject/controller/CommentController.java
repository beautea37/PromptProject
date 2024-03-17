package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Comment;
import com.me.kije.promptproject.Service.CommentService;
import com.me.kije.promptproject.Service.UserService;
import com.me.kije.promptproject.dto.CommentRequest;
import com.me.kije.promptproject.dto.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

//public class CommentController {
//
//    @GetMapping("/comments")
//    public String comment() {
//        return "pages/user/test/sign-up";
//    }
//}


@Controller
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final UserService userService; // Assuming UserService can provide the currently logged-in user

//    @PostMapping("/comment")
//    public ResponseEntity<CommentResponse> createComment(@ModelAttribute CommentRequest commentRequest, Principal principal) {
//        // Assume the username is the same as the principal's name
//        String username = principal.getName();
//        Comment comment = commentService.addComment(commentRequest.getPromptId(), username, commentRequest.getComment());
//
//        CommentResponse response = new CommentResponse(comment);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//
//    }

    @PostMapping("/comment")
    public String createComment(@ModelAttribute CommentRequest commentRequest, Principal principal, RedirectAttributes redirectAttributes) {
        // Assume the username is the same as the principal's name
        String username = principal.getName();
        try {
            Comment comment = commentService.addComment(commentRequest.getPromptId(), username, commentRequest.getComment());
            // Add flash attributes if necessary, or perform any other actions needed before redirecting
            redirectAttributes.addFlashAttribute("message", "Comment added successfully!");
        } catch (Exception e) {
            // Handle exceptions accordingly
            redirectAttributes.addFlashAttribute("error", "Error adding comment.");
        }

        // Redirect to the prompt details page
        return "redirect:/prompt/" + commentRequest.getPromptId();
    }

    // Additional endpoints for updating or deleting comments can be added here.
//    @GetMapping("/prompt/{promptId}")
//    public String viewPromptComments(@PathVariable Long promptId, Model model) {
//        List<CommentResponse> comments = commentService.getComment(promptId)
//                .stream()
//                .map(CommentResponse::new) // Assuming you have a constructor in CommentResponse for converting Comment to CommentResponse
//                .collect(Collectors.toList());
//
//        model.addAttribute("comments", comments);
//        return "pages/prompt/promptDetail"; // name of the Thymeleaf template
//    }

}
