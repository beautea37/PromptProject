package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.dto.UserRequest;
import com.me.kije.promptproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(UserRequest dto) {
        return userRepository.save(User.builder()
                .username(dto.getUsername())
                .nickname(dto.getNickname())
                .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .email(dto.getEmail())
                .build()).getId();


    }

//    public User login(UserRequest dto) {
//        return userRepository.findById(dto.getId)
//    }


}
