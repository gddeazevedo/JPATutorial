package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Course;
import com.example.jpaTutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeachersRepositoryTest {

    @Autowired
    private TeachersRepository repository;

    @Test
    public void saveTeacher() {
//        Course course1 = Course.builder()
//                .credits(12)
//                .title("Linear algebra")
//                .build();
//        Course course2 = Course.builder()
//                .credits(12)
//                .title("AI")
//                .build();
//        Course course3 = Course.builder()
//                .credits(12)
//                .title("Calculus")
//                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Girafales")
                .lastName("Samba")
                //.courses(List.of(course1, course2, course3))
                .build();

        repository.save(teacher);
    }

}