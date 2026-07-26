package com.edtech.modules.setting.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.setting.dto.SettingRequest;
import com.edtech.modules.setting.dto.SettingResponse;
import com.edtech.modules.setting.service.SettingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/public/settings")
    public ApiResponse<List<SettingResponse>> getAllSettings() {

        return ApiResponse.<List<SettingResponse>>builder()
                .success(true)
                .message("Settings fetched successfully")
                .data(settingService.getAllSettings())
                .build();
    }

    @GetMapping("/public/settings/{key}")
    public ApiResponse<SettingResponse> getSetting(
            @PathVariable String key
    ) {

        return ApiResponse.<SettingResponse>builder()
                .success(true)
                .message("Setting fetched successfully")
                .data(settingService.getSetting(key))
                .build();
    }

    @PostMapping("/admin/settings")
    public ApiResponse<SettingResponse> saveSetting(
            @Valid @RequestBody SettingRequest request
    ) {

        return ApiResponse.<SettingResponse>builder()
                .success(true)
                .message("Setting saved successfully")
                .data(settingService.saveSetting(request))
                .build();
    }

    @DeleteMapping("/admin/settings/{id}")
    public ApiResponse<Void> deleteSetting(
            @PathVariable Long id
    ) {

        settingService.deleteSetting(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Setting deleted successfully")
                .build();
    }
}