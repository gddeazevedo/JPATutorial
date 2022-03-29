package com.example.jpaTutorial.repositories;

import com.example.jpaTutorial.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialsRepository extends JpaRepository<CourseMaterial, Long> {
}
