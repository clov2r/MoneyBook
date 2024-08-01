package com.eureka.myspring.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> {
                authorizeRequests
                    .requestMatchers("/", "/index.html", "/loginSuccessView.html", "/dailyExpense.html", "/myPage.html").permitAll()
                    .anyRequest().authenticated();
            })
            .oauth2Login(oauth2Login -> 
                oauth2Login
                    .defaultSuccessUrl("/loginSuccessView.html", true)
            );

        return http.build();
    }
}
