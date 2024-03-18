package com.me.kije.promptproject.repository;

import com.me.kije.promptproject.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Find comments by Prompt
    List<Comment> findByPromptId(Long promptId);

//    List<Comment> delete(comment);
}
