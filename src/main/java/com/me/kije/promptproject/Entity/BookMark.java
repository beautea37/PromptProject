package com.me.kije.promptproject.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "promptId", nullable = false)
    private Prompt prompt;

    @Column(nullable = false)
    private LocalDateTime bookmarkedAt;

    public BookMark(String username, Prompt prompt) {
        this.username = username;
        this.prompt = prompt;
        this.bookmarkedAt = LocalDateTime.now();
    }
}