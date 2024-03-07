package com.me.kije.promptproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter

//@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String nickName;
    private String password;
    private String email;

    @Builder(toBuilder = true)
    public User(String userName, String nickName, String password, String email) {
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

}