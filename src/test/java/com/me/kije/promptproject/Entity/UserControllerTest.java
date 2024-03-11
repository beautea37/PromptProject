package com.me.kije.promptproject.Entity;

import com.me.kije.promptproject.Service.UserService;
import com.me.kije.promptproject.controller.UserController;
import com.me.kije.promptproject.dto.UserRequest;
import com.me.kije.promptproject.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@WebMvcTest(controllers = UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Test
//    public void testShowSignUpForm() throws Exception {
//        mockMvc.perform(get("/sign-up"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("pages/user/sign-up"))
//                .andExpect(model().attributeExists("user"));
//    }
//
////    @Test
////    public void testRegisterUser() throws Exception {
////        mockMvc.perform(post("/sign-up")
////                        .param("userName", "testUser")
////                        .param("nickName", "Test Nickname")
////                        .param("password", "password")
////                        .param("email", "test@example.com"))
////                .andExpect(status().is3xxRedirection())
////                .andExpect(redirectedUrl("/"));
////
////        verify(userService).save(any(User.class));
////    }
//}
