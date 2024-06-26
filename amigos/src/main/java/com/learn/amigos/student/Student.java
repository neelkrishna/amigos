package com.learn.amigos.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    @Transient
    private int age;
    private LocalDate dob;
    private String email;

    // empty constructor
    public Student() {
    }

    // all attributes
    public Student(long id,
                   String name,
                   LocalDate dob,
                   String email) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
    // all attributes except ID
    public Student(String name,
                   LocalDate dob,
                   String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    // getters/setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Period.between (this.dob, LocalDate.now()) .getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(name, student.name) && Objects.equals(dob, student.dob) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dob, email);
    }
}
