package com.me.kije.promptproject.Service;

import com.me.kije.promptproject.Entity.User;
import com.me.kije.promptproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) {
        System.out.println("loadUsername");
        System.out.println("Username : " + username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(("UserDetailService 오류. 원인 : " + username)));

//        return userRepository.findByUserName(userName)
//                .map(user -> new org.springframework.security.core.userdetails.User(
//                        user.getUsername(),
//                        user.getPassword(),
//                        AuthorityUtils.createAuthorityList("ROLE_USER") // or fetch actual roles from user
//                ))
//                .orElseThrow(() -> new UsernameNotFoundException("User '" + userName + "' not found"));
    }
}
