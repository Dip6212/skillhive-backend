package com.edtech.modules.course.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ModuleResponse {

    private Long id;

    private String title;

    private String description;

    private String duration;

    private Integer displayOrder;

}