package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.controller.PromptController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPromptRequest {

    private String title;
    private String subTitle;
    private String content;

    public Prompt toEntity() {
        return Prompt.builder()
                .title(title)
                .subTitle(subTitle)
                .content(content)
                .build();
    }
}
