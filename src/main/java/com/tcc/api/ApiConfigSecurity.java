package com.tcc.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ApiConfigSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
        http
                .csrf(csrf -> csrf.disable( )) // Importante desabilitar para conseguir fazer POST/PUT sem token
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // A "chave mágica": libera absolutamente tudo
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // Útil se você usar H2 Console depois

        return http.build( );
    }
}
