package com.edtech.modules.partner.dto;

import com.edtech.modules.media.dto.MediaResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartnerResponse {

    private Long id;

    private String name;

    private String websiteUrl;

    private Integer displayOrder;

    private Boolean isActive;

    private MediaResponse logo;
}