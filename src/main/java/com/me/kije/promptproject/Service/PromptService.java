package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.repository.PromptRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PromptService {

    @Autowired
    private final PromptRepository promptRepository;


    //글 저장
    public Prompt createPrompt(Prompt prompt) {
        return promptRepository.save(prompt);
    }

    public List<Prompt> getAllPrompts() {
        return promptRepository.findAll();
    }

    public Prompt getPromptById(Long id) {
        return promptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prompt not found with id: " + id));
    }

    public Prompt updatePrompt(Long id, Prompt promptDetails) {
        Prompt prompt = getPromptById(id);

        prompt.setTitle(promptDetails.getTitle());
        prompt.setContent(promptDetails.getContent());
        // 여기서 필요한 다른 필드들을 업데이트

        return promptRepository.save(prompt);
    }

    public void deletePrompt(Long id) {
        Prompt prompt = getPromptById(id);
        promptRepository.delete(prompt);
    }
}
