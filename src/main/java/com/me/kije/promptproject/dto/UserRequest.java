package com.me.kije.promptproject.dto;


import com.me.kije.promptproject.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequest {

    private String userName;
    private String nickName;
    private String password;
    private String email;
    private LocalDateTime signUpDate;

//    public User toEntity() {
//                .userName(userName)
//                .nickName(nickName)
//                .password(password)
//                .email(email)
//                .signUpDate(signUpDate)
//                .build();
//    }
}
