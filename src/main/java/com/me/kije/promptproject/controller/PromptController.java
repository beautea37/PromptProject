package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Service.PromptService;
import com.me.kije.promptproject.dto.AddPromptRequest;
import com.me.kije.promptproject.dto.PromptViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
//@RestController
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

    //메인 페이지
    @GetMapping("/")
    public String mainPage(Model model){
        List<PromptViewResponse> prompts = promptService.findAll()
                .stream()
                .map(PromptViewResponse::new)
                .toList();

        model.addAttribute("prompts", prompts);
        return "pages/index";
    }

    //글 작성
    @GetMapping("/save")
    public String createPrompt(@RequestParam(required = false) Long id, Model model) {

        Prompt prompt = new Prompt();

        if (id == null) {
            model.addAttribute("prompt", new PromptViewResponse(prompt));
        } else {
            model.addAttribute("prompt", new PromptViewResponse(prompt));
        }
        return "pages/prompt";
    }

    // 글 저장
    @PostMapping("/save")
    public ResponseEntity<Prompt> addPrompt(@RequestBody AddPromptRequest request) {

        Prompt savedPrompt = promptService.save(request.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPrompt);
    }


    // 자세히 보기
//    @GetMapping("/prompt/{id}")
//    public ResponseEntity<Prompt> getPromptById(@PathVariable Long id) {
////        return ResponseEntity.ok(promptService.getPromptById(id));
//        return "pages/promptDetails";
//    }

//    @GetMapping("/*/prompt/{id}*/ /test")
    @GetMapping("/test/{id}")
    public String getPromptById(@PathVariable Long id, Model model) {
        Prompt prompt = promptService.findById(id);
        model.addAttribute("prompt", new PromptViewResponse(prompt));

        return "pages/promptDetail";
    }

    // 프롬프트 업데이트
//    @PutMapping("/{id}")
//    public ResponseEntity<Prompt> updatePrompt(@PathVariable Long id, @RequestBody Prompt promptDetails) {
////        return ResponseEntity.ok(promptService.updatePrompt(id, promptDetails));
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrompt(@PathVariable Long id) {
        promptService.delete(id);
        return ResponseEntity.ok().build();
    }
}
