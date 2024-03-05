package com.me.kije.promptproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class UpdatePromptRequest {

    private String title;
    private String subTitle;
    private String content;
}
