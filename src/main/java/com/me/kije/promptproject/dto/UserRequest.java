package com.me.kije.promptproject.dto;


import com.me.kije.promptproject.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserRequest {

    private String userName;
    private String nickName;
    private String password;
    private String email;

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .nickName(nickName)
                .password(password)
                .email(email)
                .build();
    }
}
