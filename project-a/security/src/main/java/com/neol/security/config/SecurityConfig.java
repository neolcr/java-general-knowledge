package com.neol.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public ReactiveUserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("john")
                .password(passwordEncoder().encode("1234"))
                .authorities("read")
                .build();

        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http){
        return http
                .httpBasic()
                .and()
                    .authorizeExchange()
                        .pathMatchers("/demo/**").authenticated()
                        .anyExchange().permitAll()
                .and()
                    .build();
    }
}
