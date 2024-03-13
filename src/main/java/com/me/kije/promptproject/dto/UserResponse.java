package com.me.kije.promptproject.dto;

import com.me.kije.promptproject.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
public class UserResponse {

    private String userName;
    private String nickName;
    private String password;
    private String email;
    private LocalDateTime signUpDate;

    public UserResponse(User user) {
//        this.userName = user.getUserName();
        this.nickName = user.getNickName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
