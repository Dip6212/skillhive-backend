package com.edtech.modules.hero.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.hero.dto.HeroRequest;
import com.edtech.modules.hero.dto.HeroResponse;
import com.edtech.modules.hero.service.HeroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HeroController {

    private final HeroService heroService;

    @GetMapping("/public/hero")
    public ApiResponse<HeroResponse> getHero() {

        return ApiResponse.<HeroResponse>builder()
                .success(true)
                .message("Hero fetched successfully")
                .data(heroService.getActiveHero())
                .build();
    }

    @GetMapping("/admin/heroes")
    public ApiResponse<List<HeroResponse>> getAllHeroes() {

        return ApiResponse.<List<HeroResponse>>builder()
                .success(true)
                .message("Heroes fetched successfully")
                .data(heroService.getAllHeroes())
                .build();
    }

    @PostMapping("/admin/heroes")
    public ApiResponse<HeroResponse> createHero(
            @Valid @RequestBody HeroRequest request
    ) {

        return ApiResponse.<HeroResponse>builder()
                .success(true)
                .message("Hero created successfully")
                .data(heroService.createHero(request))
                .build();
    }

    @PutMapping("/admin/heroes/{id}")
    public ApiResponse<HeroResponse> updateHero(
            @PathVariable Long id,
            @Valid @RequestBody HeroRequest request
    ) {

        return ApiResponse.<HeroResponse>builder()
                .success(true)
                .message("Hero updated successfully")
                .data(heroService.updateHero(id, request))
                .build();
    }

    @DeleteMapping("/admin/heroes/{id}")
    public ApiResponse<Void> deleteHero(
            @PathVariable Long id
    ) {

        heroService.deleteHero(id);

        return ApiResponse.<Void>builder()
                .success(true)
                .message("Hero deleted successfully")
                .build();
    }
}