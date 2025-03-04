package com.java.appserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConf {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
        http.csrf(AbstractHttpConfigurer::disable);
//        참조메서드 기법 ::
        http.cors(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(req ->{
            req.anyRequest().permitAll();
        });
//        개발을 위해 다 풀어놓고 진행하는 중

        return  http.build();
    }
}
