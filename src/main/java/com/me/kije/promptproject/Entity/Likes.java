package com.me.kije.promptproject.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "promptId", nullable = false)
    private Prompt prompt;

    @Column(nullable = false)
    private LocalDateTime likedAt;

    public Likes(String username, Prompt prompt) {
        this.username = username;
        this.prompt = prompt;
        this.likedAt = LocalDateTime.now();
    }
}
