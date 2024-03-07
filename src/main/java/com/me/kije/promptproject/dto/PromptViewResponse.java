package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.Prompt;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class PromptViewResponse {

    private Long id;
    private String title;
    private String subTitle;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PromptViewResponse(Prompt prompt) {
        this.id = prompt.getId();
        this.title = prompt.getTitle();
        this.subTitle = prompt.getSubTitle();
        this.content = prompt.getContent();
        this.createdDate = prompt.getCreatedDate();
        this.modifiedDate = prompt.getModifiedDate();
    }
}
