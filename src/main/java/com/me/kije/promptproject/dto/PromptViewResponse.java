package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.Prompt;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class PromptViewResponse {

    private final Long id;
    private final String title;
    private final String subTitle;
    private final String content;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public PromptViewResponse(Prompt prompt) {
        this.id = prompt.getId();
        this.title = prompt.getTitle();
        this.subTitle = prompt.getSubTitle();
        this.content = prompt.getContent();
        this.createdDate = prompt.getCreatedDate();
        this.modifiedDate = prompt.getModifiedDate();
    }
}
