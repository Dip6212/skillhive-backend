package com.edtech.modules.course.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Slug is required")
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
}