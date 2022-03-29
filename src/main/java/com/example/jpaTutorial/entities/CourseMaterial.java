package com.example.jpaTutorial.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "CourseMaterial")
@Table(name = "course_materials")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_materials_sequence",
            sequenceName = "course_materials_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_materials_sequence"
    )
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "id",
            nullable = false
    )
    private Course course;
}
