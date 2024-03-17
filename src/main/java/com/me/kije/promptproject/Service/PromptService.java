package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.DataNotFoundException;
import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.dto.AddPromptRequest;
import com.me.kije.promptproject.dto.UpdatePromptRequest;
import com.me.kije.promptproject.dto.UserRequest;
import com.me.kije.promptproject.repository.PromptRepository;
import com.me.kije.promptproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PromptService {

    private final PromptRepository promptRepository;
    private final UserRepository userRepository;


//    //글 저장
//    public Prompt save(Prompt prompt/*, User user*/) {
////        userUser
//        return promptRepository.save(prompt);
//    }

    public Prompt save(AddPromptRequest request, String username) {

        return promptRepository.save(request.toPrompt(username));

    }

    //글 조회
    public List<Prompt> findAll() {
        return promptRepository.findAll();
    }

    //목록 조회
    public Prompt getPromptById(Long id) {
        return promptRepository.findById(id).orElseThrow(() -> new RuntimeException("Prompt 조회 불가 id 값 : " + id));
    }

    //수정 업데이트
    @Transactional
    public Prompt modify(Long id, UpdatePromptRequest request) {
        Prompt prompt = promptRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id값이 없습니다. id 값은 : " + id));

        authorizePromptAuthor(prompt);

        prompt.update(request.getTitle(), request.getSubTitle(), request.getContent());
        return prompt;
    }

    public void delete(Long id) {
        Prompt prompt = promptRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Delete할 id 값이 없습니다. id값 : " + id));

        authorizePromptAuthor(prompt);
        promptRepository.delete(prompt);

    }

    public Prompt findById(long id) {
        return promptRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("findById not found : " + id));
    }


    private static void authorizePromptAuthor(Prompt prompt) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!prompt.getAuthor().equals(username)) {
            throw new IllegalArgumentException("작성자가 아닙니다.");
        }
    }
}
