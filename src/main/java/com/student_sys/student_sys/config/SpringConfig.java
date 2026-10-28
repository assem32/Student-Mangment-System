package com.student_sys.student_sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
public class SpringConfig {


    public static final String[] PUBLIC_URLS= {
        "/login",
        "/css/**",
        "/images/**",
        "/js/**",
        "/error"
    } ;


    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.authorizeHttpRequests(
            auth -> auth.requestMatchers(PUBLIC_URLS)
            .permitAll()
            .anyRequest()
            .authenticated()
            
        ).formLogin(
            form -> form
            .loginPage("/login")
            .loginProcessingUrl("login")
            .defaultSuccessUrl("/dashboard",true)
            .permitAll()
        ).logout(
            logout -> logout
            .logoutSuccessUrl("/logout?logout")
            .permitAll()
        );

        return httpSecurity.build();
    }

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    
}
