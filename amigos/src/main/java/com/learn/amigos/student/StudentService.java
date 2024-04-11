package com.learn.amigos.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    public List<Student> getStudents() {
        return List.of(
                new Student(1L,
                        "Mariam",
                        21,
                        LocalDate.of(1995, Month.APRIL, 12),
                        "mariam.jamal@gmail.com"
                )
        );
    }
}
