package com.edtech.modules.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdminResponse {

    private Long id;

    private String name;

    private String email;

    private String role;
}
