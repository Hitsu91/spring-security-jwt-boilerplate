package dev.chaofang.springsecurityjwt;

import dev.chaofang.springsecurityjwt.security.model.User;
import dev.chaofang.springsecurityjwt.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static dev.chaofang.springsecurityjwt.security.model.Role.ADMIN;
import static dev.chaofang.springsecurityjwt.security.model.Role.USER;

@SpringBootApplication
@RequiredArgsConstructor
@Log4j2
public class SpringSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner insertAdmin() {
        return args -> {
            log.info("");
            if (userRepository.count() == 0) {

                userRepository.save(
                        User.builder()
                                .username("admin")
                                .password(passwordEncoder.encode("admin"))
                                .role(ADMIN)
                                .build()
                );

                userRepository.save(
                        User.builder()
                                .username("user")
                                .password(passwordEncoder.encode("user"))
                                .role(USER)
                                .build()
                );

            }
        };
    }

}
