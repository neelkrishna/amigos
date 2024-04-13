package com.learn.amigos.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.APRIL;
import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student("Mariam", LocalDate.of(2000, JANUARY, 5), "miriam@biz.info");
            Student alex = new Student("Alex", LocalDate.of(2003, APRIL, 9), "alex@aol.gov");
            repository.saveAll(List.of(mariam, alex));
        };
    }
}