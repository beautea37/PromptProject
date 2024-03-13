package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.dto.UserRequest;
import com.me.kije.promptproject.repository.UserRepository;
import groovy.transform.AutoClone;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(UserRequest dto) {
        return userRepository.save(User.builder()
                .userName(dto.getUserName())
                .nickName(dto.getNickName())
                .password(/*bCryptPasswordEncoder.encode*/(dto.getPassword()))
                .email(dto.getEmail())
                .build()).getId();


    }

}
