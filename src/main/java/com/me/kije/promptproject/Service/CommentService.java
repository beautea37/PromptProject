package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.Comment;
import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.dto.CommentRequest;
import com.me.kije.promptproject.repository.CommentRepository;
import com.me.kije.promptproject.repository.PromptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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


//    public void deleteComment(CommentRequest commentRequest) {
//        Comment comment = commentRepository.findById(commentRequest.getPromptId())
//                .orElseThrow(() -> new IllegalArgumentException("Comment Delete Service Error : " + commentRequest.getPromptId()));
//
//        authorizePromptAuthor((Comment) comment);
//        commentRepository.deleteById(commentRequest.getPromptId());
//    }\


    //----------------------------------------------------------------
//    public void deleteComment(Long commentId) {
//        Comment comment = commentRepository.findById(commentId)
//                .orElseThrow(() -> new IllegalArgumentException("Comment Delete Service Error : " + commentId));
//
//        authorizePromptAuthor((Comment) comment);
//        commentRepository.deleteById(commentId);
//    }
//-----------------------------------------------------------------------
    public Long deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found with id: " + commentId));

        Long promptId = comment.getPrompt().getId();// Assuming getPromptId() gets the ID of the prompt associated with this comment
        authorizePromptAuthor(comment);
        commentRepository.deleteById(commentId);
        return promptId;
    }


    private static void authorizePromptAuthor(Comment comment) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!comment.getUsername().equals(username)) {
            throw new IllegalArgumentException("삭제 권한이 없습니다..");
        }
    }

    // Additional methods for comment manipulation (e.g., delete, update) can be added here.
}
