package com.example.userservice.config;

import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeRequests() // 인증, 인가 설정을 시작합니다.
//                .requestMatchers("/user-service/health-check").permitAll()// 해당 주소는 인증, 인가 없이 접속 가능하며
////                .anyRequest().hasRole("ADMIN") // 나머지는 어드민 권한을 요구하겠다.
//                .anyRequest().authenticated() //나머지에 대해서는 인증을 요구하겠습니다.
//                .and() // 그리고 다음 설정으로
////                .formLogin()// 로그인 폼 설정을 시작한다.
////                .loginPage("/login") // 해당 주소로 들어오면 로그인 폼으로 연결,
////                .defaultSuccessUrl("/articles")// 로그인에 성공하면 이 주소로 이동.
////                .and()// 그리고 다음 설정으로
////                .logout()// 로그아웃 관련 설정을 할 것이고
////                .logoutSuccessUrl("/login")// 로그아웃 성공시 로그인 페이지로 보낼거고
////                .invalidateHttpSession(true)// 로그인 흔적을 파기합니다.
////                .and() // 그리고
//                .csrf().disable() // 테스트 설정을 편하게 하기 위해 csrf검증을 끕니다
//                .build();
        return http
                .authorizeHttpRequests(auth ->
                    auth.anyRequest().permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
