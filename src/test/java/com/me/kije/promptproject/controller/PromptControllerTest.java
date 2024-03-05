package com.me.kije.promptproject.controller;

import com.me.kije.promptproject.Entity.Prompt;
import com.me.kije.promptproject.Service.PromptService;
import com.me.kije.promptproject.dto.AddPromptRequest;
import com.me.kije.promptproject.repository.PromptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PromptControllerTest {

    @Autowired
    PromptService promptService;

//    @InjectMocks
//    private PromptService promptService;

    @Mock
    private PromptRepository promptRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("create test")
    @Test
    void whenSavePrompt_thenReturnsSavedPrompt() {
        // Arrange
        final String url = "save";
        final String title = "title";
        final String subTitle = "subTitle";
        final String content = "content";
        final AddPromptRequest addPromptRequest = new AddPromptRequest(title, subTitle, content);

        ResultActions result = Mockito.mock();

    }

}