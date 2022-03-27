package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    // Native query
    @Query(
            value = "SELECT * FROM students WHERE email = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailNative(String email);

    // Native query named parameter
    @Query(
            value = "SELECT * FROM students WHERE email = :email",
            nativeQuery = true
    )
    Optional<Student> getStudentByEmailNativeNamedParameter(
            @Param("email") String email
    );
}
