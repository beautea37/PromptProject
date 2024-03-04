package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Service.PromptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
public class PromptController {

    private final PromptService promptService;

    // 모든 프롬프트 조회
//    @GetMapping("/")
//    public List<Prompt> getAllPrompts() {
//        return promptService.getAllPrompts();
//    }
    @GetMapping("/")
    public String main(){
        return "index";
    }

    // 새 프롬프트 생성
    @PostMapping
    public ResponseEntity<Prompt> createPrompt(@RequestBody Prompt prompt) {
        return new ResponseEntity<>(promptService.createPrompt(prompt), HttpStatus.CREATED);
    }

    // ID로 프롬프트 조회
    @GetMapping("/{id}")
    public ResponseEntity<Prompt> getPromptById(@PathVariable Long id) {
        return ResponseEntity.ok(promptService.getPromptById(id));
    }

    // 프롬프트 업데이트
    @PutMapping("/{id}")
    public ResponseEntity<Prompt> updatePrompt(@PathVariable Long id, @RequestBody Prompt promptDetails) {
        return ResponseEntity.ok(promptService.updatePrompt(id, promptDetails));
    }

    // 프롬프트 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrompt(@PathVariable Long id) {
        promptService.deletePrompt(id);
        return ResponseEntity.noContent().build();
    }
}
