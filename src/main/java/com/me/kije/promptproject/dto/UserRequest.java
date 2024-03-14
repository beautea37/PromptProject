package com.me.kije.promptproject.dto;


import com.me.kije.promptproject.Entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @NotNull
    @Size(min = 3, max = 50)
    private String nickname;

    @NotNull
    @Size(min = 6, max = 100)
    private String password;

    @NotNull
    @Email
    private String email;



//    private LocalDateTime signUpDate;

//    public User toEntity() {
//                .userName(userName)
//                .nickName(nickName)
//                .password(password)
//                .email(email)
//                .signUpDate(signUpDate)
//                .build();
//    }
}
