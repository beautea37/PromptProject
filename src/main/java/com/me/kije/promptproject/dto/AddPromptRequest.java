package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.controller.PromptController;
import groovy.transform.PropertyOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddPromptRequest {

    private String title;
    private String subTitle;
    private String content;

//    public Prompt toEntity() {
//        return Prompt.builder()
//                .title(title)
//                .subTitle(subTitle)
//                .content(content)
//                .author(author)
//                .build();
//    }



    public Prompt toPrompt(String author) {
        return Prompt.builder()
                .title(title)
                .subTitle(subTitle)
                .content(content)
                .author(author) // Assuming the builder pattern correctly initializes fields
                .build();
    }
}
