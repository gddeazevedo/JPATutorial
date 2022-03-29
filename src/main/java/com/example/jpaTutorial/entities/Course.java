package com.example.jpaTutorial.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(mappedBy = "course") // bidirectional mapping, this column is mapped by course attr in CourseMaterial
    private CourseMaterial courseMaterial;

    // Many courses can be taught by one teacher
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "id" // Course id
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id" // Student id
            )
    )
    private List<Student> students;

    public void addStudents(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
