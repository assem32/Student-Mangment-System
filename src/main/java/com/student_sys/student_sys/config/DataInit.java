package com.student_sys.student_sys.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.student_sys.student_sys.model.Users;
import com.student_sys.student_sys.repository.UserRepo;

@Configuration 
public class DataInit {
    private final PasswordEncoder passwordEncoder;

    DataInit(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean 
    CommandLineRunner loadSampleData(UserRepo userRepo,
        PasswordEncoder passwordEncoder
    ){
        return args -> 
        {
            if(!userRepo.existsByUserName("admin"))
            {
                Users user = new Users();
            user.setUserName("admin");
            user.setPassword(passwordEncoder.encode("admin"));
            user.setActive(true);
            userRepo.save(user);
        }
        };
    }
}
