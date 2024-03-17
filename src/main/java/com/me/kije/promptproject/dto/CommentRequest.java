package com.me.kije.promptproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentRequest {
    private String comment;
    private Long promptId; // Assuming you pass the prompt ID in some way, maybe as a hidden input or part of the URL.

    // Constructors, getters, and setters
}
