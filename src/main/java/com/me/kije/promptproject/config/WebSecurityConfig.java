package com.me.kije.promptproject.config;//package com.me.kije.promptproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
////package com.me.kije.promptproject.config;
////import com.me.kije.promptproject.Service.UserDetailService;
////import lombok.RequiredArgsConstructor;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
////import org.springframework.security.web.SecurityFilterChain;
////import org.springframework.web.bind.annotation.RequestBody;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
////
////@EnableWebSecurity
////@RequiredArgsConstructor
////@Configuration
////public class WebSecurityConfig {
////
////    private final UserDetailService userService;
////
////    @Bean
////    public WebSecurityCustomizer configure() {
////        return (web) -> web.ignoring()
//////                .requestMatchers(toH2Console())
////                .requestMatchers("/static/**");
////    }
////
////    @Bean
////    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        return http
////                .authorizeRequests()
////                .requestMatchers("/login", "/sign-up", "/", "/save").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .formLogin(formLogin -> formLogin
////
////                        .loginPage("/login")
////                        .defaultSuccessUrl("/")
////                )
////                .logout(logout -> logout
////                        .logoutSuccessUrl("/login")
////                        .invalidateHttpSession(true)
////                )
////                .csrf(AbstractHttpConfigurer::disable)
////                .build();
////    }
////
////    @Bean
////    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception {
////        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////
////        daoAuthenticationProvider.setUserDetailsService(userService);
////        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
////
////        return daoAuthenticationProvider;
////    }
////
////    @Bean
////    public BCryptPasswordEncoder bCryptPasswordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
////
////
////}
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig {
//
//
//

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests.anyRequest().permitAll()
                )
                .csrf().disable(); // CSRF 보호 기능을 비활성화합니다. 테스트 목적으로만 사용하세요.

        return http.build();
    }
}