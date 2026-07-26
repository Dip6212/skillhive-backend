package com.edtech.modules.partner.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PartnerRequest {

    @NotBlank
    private String name;

    private String websiteUrl;

    private Integer displayOrder;

    private Boolean isActive;

    private Long logoId;
}