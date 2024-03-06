package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Service.PromptService;
import com.me.kije.promptproject.dto.AddPromptRequest;
import com.me.kije.promptproject.dto.PromptViewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public String main(){
        return "pages/index";
    }

    @GetMapping("/save")
    public String createPrompt(@RequestParam(required = false) Long id, Model model) {

        if (id == null) {
            model.addAttribute("prompt", new PromptViewResponse());
        } else {
            Prompt prompt = promptService.findById(id);
//            model.addAttribute("prompt", new PromptViewResponse());
        }
        return "pages/prompt";
    }

    // 새 프롬프트 생성
    @PostMapping("/save")
    public ResponseEntity<Prompt> addPrompt(@RequestBody AddPromptRequest request) {

        Prompt savedPrompt = promptService.save(request.toEntity());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPrompt);
    }


    // ID로 프롬프트 조회
    @GetMapping("/{id}")
    public ResponseEntity<Prompt> getPromptById(@PathVariable Long id) {
        return ResponseEntity.ok(promptService.getPromptById(id));
    }

    // 프롬프트 업데이트
//    @PutMapping("/{id}")
//    public ResponseEntity<Prompt> updatePrompt(@PathVariable Long id, @RequestBody Prompt promptDetails) {
////        return ResponseEntity.ok(promptService.updatePrompt(id, promptDetails));
//    }

    // 프롬프트 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePrompt(@PathVariable Long id) {
//        promptService.deletePrompt(id);
//        return ResponseEntity.noContent().build();
//    }
}
