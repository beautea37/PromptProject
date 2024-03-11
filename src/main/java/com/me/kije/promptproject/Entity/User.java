package com.me.kije.promptproject.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter

@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @CreatedDate
    private LocalDateTime signUpDate;

    @Builder
    public User(String userName, String nickName, String password, String email/*, LocalDateTime signUpDate*/) {
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
//        this.signUpDate = signUpDate;
    }

}