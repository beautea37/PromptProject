package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {


    private UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

//    public User find



}
