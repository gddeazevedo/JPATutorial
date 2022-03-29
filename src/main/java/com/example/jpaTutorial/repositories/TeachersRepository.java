package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teacher, Long> {
}
