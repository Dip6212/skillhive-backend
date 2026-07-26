package com.edtech.modules.technology.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TechnologyRequest {

    @NotBlank
    private String name;

    private String iconUrl;

    private Integer displayOrder;

    private Boolean isActive;
}