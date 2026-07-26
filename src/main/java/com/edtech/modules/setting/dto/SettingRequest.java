package com.edtech.modules.setting.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SettingRequest {

    @NotBlank(message = "Setting key is required")
    private String key;

    private String value;

}