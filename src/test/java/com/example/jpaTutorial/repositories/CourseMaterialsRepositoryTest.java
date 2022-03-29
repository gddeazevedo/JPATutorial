package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Course;
import com.example.jpaTutorial.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialsRepositoryTest {

    @Autowired
    private CourseMaterialsRepository repository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("DSA")
                .credits(6)
                .build();

        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .url("google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println(courseMaterials);
    }
}
