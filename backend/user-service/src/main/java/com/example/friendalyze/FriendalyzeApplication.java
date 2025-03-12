
package com.example.friendalyze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.userservice"})
@EnableJpaRepositories(basePackages = "com.example.userservice.repository")
@EntityScan(basePackages = "com.example.userservice.model")
public class FriendalyzeApplication {
    public static void main(String[] args) {
        SpringApplication.run(FriendalyzeApplication.class, args);
    }
}
