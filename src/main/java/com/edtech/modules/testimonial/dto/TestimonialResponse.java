package com.edtech.modules.testimonial.dto;

import com.edtech.modules.media.dto.MediaResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestimonialResponse {

    private Long id;

    private String name;

    private String designation;

    private String company;

    private String review;

    private Integer rating;

    private Integer displayOrder;

    private Boolean isActive;

    private MediaResponse profileImage;
}