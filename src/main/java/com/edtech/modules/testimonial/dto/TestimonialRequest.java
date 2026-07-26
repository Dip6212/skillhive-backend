package com.edtech.modules.testimonial.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TestimonialRequest {

    @NotBlank
    private String name;

    private String designation;

    private String company;

    @NotBlank
    private String review;

    @Min(1)
    @Max(5)
    private Integer rating;

    private Long profileImageId;

    private Integer displayOrder;

    private Boolean isActive;
}