package com.edtech.modules.enquiry.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EnquiryResponse {

    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private String course;

    private String message;

    private String status;

    private LocalDateTime createdAt;
}