package com.me.kije.promptproject.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prompt_id")
    private Prompt prompt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;
}
