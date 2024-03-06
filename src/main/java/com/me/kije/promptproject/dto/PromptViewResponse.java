package com.me.kije.promptproject.dto;

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

    public PromptViewResponse(Long id, String title, String subTitle, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
