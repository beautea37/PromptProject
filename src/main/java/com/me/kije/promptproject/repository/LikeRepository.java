package com.me.kije.promptproject.repository;

import com.me.kije.promptproject.Entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByUserIdAndPromptId(Long userId, Long promptId);
    int countByPromptId(Long promptId);
}
