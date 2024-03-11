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

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

//    public User save(User user) {
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//        return userRepository.save(User.builder()
//                .userName(user.getUserName())
//                .nickName(user.getNickName())
//                .email(user.getEmail())
//                .password(encoder.encode(user.getPassword()))
//                .build());
//    }




    public Long save(UserRequest user) {

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return userRepository.save(User.builder()
                .userName(user.getUserName())
                .nickName(user.getNickName())
                .email(user.getEmail())
                .password(bCryptPasswordEncoder.encode(user.getPassword()))
                .build());
    }

//    public User find


}
