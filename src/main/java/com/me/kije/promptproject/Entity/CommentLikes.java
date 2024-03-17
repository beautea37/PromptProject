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
public class CommentLikes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commentId", nullable = false)
    private Comment comment;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private LocalDateTime likedAt;

    public CommentLikes(Comment comment, String username) {
        this.comment = comment;
        this.username = username;
        this.likedAt = LocalDateTime.now();
    }
}