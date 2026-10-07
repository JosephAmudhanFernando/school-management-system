package com.school.management.studentservice.config;

import com.school.management.studentservice.entity.Student;
import com.school.management.studentservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeederConfig {

    @Bean
    public CommandLineRunner seedDatabase(
            StudentRepository repository
    ) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Student(
                        "STU-2026-001",
                        "Arjun",
                        "Kumar",
                        "10th Grade",
                        "PENDING"
                ));
            }
        };
    }
}