package com.edtech.modules.technology.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.technology.dto.TechnologyRequest;
import com.edtech.modules.technology.dto.TechnologyResponse;
import com.edtech.modules.technology.service.TechnologyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TechnologyController {

    private final TechnologyService technologyService;

    @GetMapping("/public/technologies")
    public ApiResponse<List<TechnologyResponse>> getTechnologies() {

        return ApiResponse.<List<TechnologyResponse>>builder()
                .success(true)
                .message("Technologies fetched successfully")
                .data(technologyService.getActiveTechnologies())
                .build();
    }

    @GetMapping("/admin/technologies")
    public ApiResponse<List<TechnologyResponse>> getAllTechnologies() {

        return ApiResponse.<List<TechnologyResponse>>builder()
                .success(true)
                .message("Technologies fetched successfully")
                .data(technologyService.getAllTechnologies())
                .build();
    }

    @PostMapping("/admin/technologies")
    public ApiResponse<TechnologyResponse> createTechnology(
            @Valid @RequestBody TechnologyRequest request
    ) {

        return ApiResponse.<TechnologyResponse>builder()
                .success(true)
                .message("Technology created successfully")
                .data(technologyService.createTechnology(request))
                .build();
    }

    @PutMapping("/admin/technologies/{id}")
    public ApiResponse<TechnologyResponse> updateTechnology(
            @PathVariable Long id,
            @Valid @RequestBody TechnologyRequest request
    ) {

        return ApiResponse.<TechnologyResponse>builder()
                .success(true)
                .message("Technology updated successfully")
                .data(technologyService.updateTechnology(id, request))
                .build();
    }

    @DeleteMapping("/admin/technologies/{id}")
    public ApiResponse<Void> deleteTechnology(
            @PathVariable Long id
    ) {

        technologyService.deleteTechnology(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Technology deleted successfully")
                .build();
    }
}