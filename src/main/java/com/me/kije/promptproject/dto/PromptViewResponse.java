package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PromptViewResponse {

    private Long id;
    private String title;
    private String subTitle;
    private String content;
    private String author;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PromptViewResponse(Prompt prompt) {
        this.id = prompt.getId();
        this.title = prompt.getTitle();
        this.subTitle = prompt.getSubTitle();
        this.content = prompt.getContent();
        this.author = prompt.getAuthor();
        this.createdDate = prompt.getCreatedDate();
        this.modifiedDate = prompt.getModifiedDate();
    }

    public void PromptModifyResponse(Prompt prompt) {
        this.title = prompt.getTitle();
        this.subTitle = prompt.getSubTitle();
        this.content = prompt.getContent();
    }
}
