package com.edtech.modules.course.dto;

import com.edtech.modules.media.dto.MediaResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CourseDetailsResponse {

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

    private List<PackageResponse> packages;

}