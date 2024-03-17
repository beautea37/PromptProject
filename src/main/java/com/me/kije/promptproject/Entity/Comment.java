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
 public class Comment {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     @ManyToOne
     @JoinColumn(name = "promptId", nullable = false)
     private Prompt prompt;

     @Column(nullable = false)
     private String username;

     @Column(nullable = false, columnDefinition = "TEXT")
     private String content;

     @Column(nullable = false)
     private LocalDateTime createdAt;

     public Comment(Prompt prompt, String username, String content) {
         this.prompt = prompt;
         this.username = username;
         this.content = content;
         this.createdAt = LocalDateTime.now();
     }
 }
