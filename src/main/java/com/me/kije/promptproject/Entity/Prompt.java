package com.me.kije.promptproject.Entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
@Getter
@Setter

@NoArgsConstructor
public class Prompt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be empty")
//    @Column(nullable = false, length = 100)
    private String title;

    @NotBlank(message = "SubTitle cannot be empty")
//    @Column(nullable = false, length = 400)
    private String subTitle;

    @NotBlank(message = "Content cannot be empty")
//    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @OneToMany(mappedBy = "prompt", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @Column(name = "author", nullable = false)
    private String author;

    //좋아요 만들어야 함.
//    Set<User> llike;

    @Builder
    public Prompt(String title, String subTitle, String content, LocalDateTime createdDate, LocalDateTime modifiedDate, String author) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.author = author;
    }

    public void  update(String title, String subTitle, String content) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
    }
}

