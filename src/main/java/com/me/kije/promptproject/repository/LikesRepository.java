package com.me.kije.promptproject.repository;

import com.me.kije.promptproject.Entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUsernameAndPromptId(String username, Long promptId);
}