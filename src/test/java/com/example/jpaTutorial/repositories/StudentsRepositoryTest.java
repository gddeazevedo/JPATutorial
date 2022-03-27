package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Guardian;
import com.example.jpaTutorial.entities.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentsRepositoryTest {

    @Autowired
    private StudentsRepository repository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("some_student@email.com")
                .firstName("Some")
                .lastName("Student")
                .build();

        repository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("some_guardian@email.com")
                .name("Some")
                .mobile("123456789")
                .build();

        Student student = Student.builder()
                .firstName("Another")
                .lastName("Student")
                .email("another_student@email.com")
                .guardian(guardian)
                .build();

        repository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = repository.findAll();
        System.out.println(studentList);
    }
}