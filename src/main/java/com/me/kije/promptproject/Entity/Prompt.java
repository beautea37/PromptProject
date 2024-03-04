package com.me.kije.promptproject.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Prompt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false/*, length = 10000*/)
    private String title;

    @Column(nullable = false, length = 10000)
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

