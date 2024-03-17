package com.me.kije.promptproject.repository;

import com.me.kije.promptproject.Entity.CommentLikes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentLikesRepository extends JpaRepository<CommentLikes, Long> {
    // Example method to find comment likes by commentId
    List<CommentLikes> findByCommentId(Long commentId);
}