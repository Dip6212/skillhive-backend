package com.edtech.modules.faq.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FaqResponse {

    private Long id;

    private String question;

    private String answer;

    private Integer displayOrder;

    private Boolean isActive;

}