package com.edtech.modules.hero.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HeroRequest {

    @NotBlank
    private String title;

    private String subtitle;

    private String description;

    private String primaryButtonText;

    private String primaryButtonLink;

    private String secondaryButtonText;

    private String secondaryButtonLink;

    private Long heroImageId;

    private Long backgroundImageId;

    private Boolean isActive;
}