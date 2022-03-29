package com.example.jpaTutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Course")
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "courses_sequence",
            sequenceName = "courses_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courses_sequence"
    )
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "credits", nullable = false)
    private Integer credits;
}
