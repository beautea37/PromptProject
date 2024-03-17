package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.dto.UserRequest;
import com.me.kije.promptproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.zip.DataFormatException;

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

    public User getUser(String username) throws DataFormatException {
        Optional<User> user = this.userRepository.findByUsername(username);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new DataFormatException("Author is not????");
        }

    }

//    public User login(UserRequest dto) {
//        return userRepository.findById(dto.getId)
//    }


}
