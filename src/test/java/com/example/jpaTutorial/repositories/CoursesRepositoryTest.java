package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Course;
import com.example.jpaTutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class CoursesRepositoryTest {

    @Autowired
    private CoursesRepository repository;

    @Test
    public void printCourses() {
        List<Course> courses = repository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Nice")
                .lastName("Teacher")
                .build();
        Course course = Course.builder()
                .title("OOP")
                .credits(8)
                .teacher(teacher)
                .build();
        repository.save(course);
    }
}
