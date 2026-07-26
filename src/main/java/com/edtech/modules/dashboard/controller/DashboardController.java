package com.edtech.modules.dashboard.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.dashboard.dto.DashboardResponse;
import com.edtech.modules.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ApiResponse<DashboardResponse> getDashboard() {

        DashboardResponse response = dashboardService.getDashboard();

        return ApiResponse.<DashboardResponse>builder()
                .success(true)
                .message("Dashboard fetched successfully")
                .data(response)
                .build();
    }

}