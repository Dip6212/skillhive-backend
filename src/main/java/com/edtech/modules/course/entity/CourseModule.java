package com.edtech.modules.course.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
        Core Java
     */
    @Column(nullable = false)
    private String title;

    /*
        Optional
     */
    @Column(length = 3000)
    private String description;

    /*
        2 Weeks
     */
    private String duration;

    /*
        Sequence
     */
    private Integer displayOrder;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private CoursePackage coursePackage;

}