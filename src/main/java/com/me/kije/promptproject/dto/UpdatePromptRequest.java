package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.Prompt;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.security.PublicKey;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePromptRequest {

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
