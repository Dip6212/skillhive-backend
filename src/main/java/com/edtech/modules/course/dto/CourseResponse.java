package com.edtech.modules.course.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseResponse {

    private Long id;

    private String title;

    private String slug;

    private String shortDescription;

    private String description;

    private String duration;

    private String level;

    private String mode;

    private Double rating;

    private Integer students;

    private String imageUrl;

    private String brochureUrl;

    private Boolean featured;

    // NEW
    private String packageName;
}