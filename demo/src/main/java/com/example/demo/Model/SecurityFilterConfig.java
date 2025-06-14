package com.example.demo.Model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityFilterConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar testes
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuarios/**", "/artistas/**", "/musicas", "/musicas/recomendadas/**", "/musicas/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()); // ou use formLogin se preferir

        return http.build();
    }
}
