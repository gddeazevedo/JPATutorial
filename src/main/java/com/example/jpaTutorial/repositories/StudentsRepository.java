package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastName(String lastName);

    List<Student> findByGuardianName(String guardianName);

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Student getStudentByEmail(String email);

    @Query("SELECT s.firstName FROM Student s WHERE s.email = ?1")
    String getStudentFirstNameByEmail(String email);
}
