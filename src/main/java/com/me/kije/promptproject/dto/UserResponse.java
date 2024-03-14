package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class UserResponse {

    private String username;
    private String nickname;
    private String password;
    private String email;
    private LocalDateTime signUpDate;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
