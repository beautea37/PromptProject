package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.Comment;
import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.repository.CommentRepository;
import com.me.kije.promptproject.repository.PromptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;
    private final PromptRepository promptRepository; // Assuming you have a PromptRepository

    public Comment addComment(Long promptId, String username, String content) {
        Prompt prompt = promptRepository.findById(promptId)
                .orElseThrow(() -> new IllegalArgumentException("Prompt not found!"));

        Comment comment = new Comment(prompt, username, content);
        return commentRepository.save(comment);
    }


    public List<Comment> getComment(Long promptId) {
        return commentRepository.findByPromptId(promptId);
    }


    // Additional methods for comment manipulation (e.g., delete, update) can be added here.
}
