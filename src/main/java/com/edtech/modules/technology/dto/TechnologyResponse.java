package com.edtech.modules.technology.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechnologyResponse {

    private Long id;

    private String name;

    private String iconUrl;

    private Integer displayOrder;

    private Boolean isActive;
}