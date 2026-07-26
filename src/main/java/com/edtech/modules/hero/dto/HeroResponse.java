package com.edtech.modules.hero.dto;

import com.edtech.modules.media.dto.MediaResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeroResponse {

    private Long id;

    private String title;

    private String subtitle;

    private String description;

    private String primaryButtonText;

    private String primaryButtonLink;

    private String secondaryButtonText;

    private String secondaryButtonLink;

    private MediaResponse heroImage;

    private MediaResponse backgroundImage;

    private Boolean isActive;
}