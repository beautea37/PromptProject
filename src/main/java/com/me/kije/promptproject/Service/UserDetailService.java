//package com.me.kije.promptproject.Service;
//
//import com.me.kije.promptproject.Entity.User;
//import com.me.kije.promptproject.dto.PromptViewResponse;
//import com.me.kije.promptproject.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//import java.security.PrivateKey;
//
//@RequiredArgsConstructor
//@Service
//public class UserDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public User loadUserByUsername(String email) {
//        return userRepository.findByUserName(email)
//                .orElseThrow(() -> new IllegalArgumentException((email)));
//    }
//}
