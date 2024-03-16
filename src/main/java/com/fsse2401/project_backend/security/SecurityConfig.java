package com.fsse2401.project_backend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        http
//
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .csrf(csrf -> csrf.disable());
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(new AntPathRequestMatcher("/public/product/all/{user_input}")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/public/product/{id}")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/public/product")).permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
//                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        http
                .oauth2ResourceServer(
                        oauth2ResourceServer -> oauth2ResourceServer.jwt(
                                jwt -> jwt.decoder(
                                        JwtDecoders.fromIssuerLocation(issuer))
                        )
                );
        return http.build();
    }

}