package com.edtech.modules.course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(length = 3000)
    private String shortDescription;

    @Column(length = 5000)
    private String description;

    private String duration;

    private String level;

    private String mode;

    private Double rating;

    private Integer students;

    private String imageUrl;

    private String brochureUrl;

    private Boolean featured;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<CoursePackage> packages = new ArrayList<>();
}