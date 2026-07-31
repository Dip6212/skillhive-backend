package com.edtech.modules.auth.controller;

import com.edtech.common.dto.ApiResponse;
import com.edtech.modules.auth.dto.LoginRequest;
import com.edtech.modules.auth.dto.LoginResponse;
import com.edtech.modules.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {

        System.out.println("Controller reached");
        System.out.println(request.getEmail());
        return ApiResponse.<LoginResponse>builder()
                .success(true)
                .message("Login successful")
                .data(authService.login(request))
                .build();
    }

    @GetMapping("/me")
    public Object me(Authentication authentication) {
        return authentication.getAuthorities();
    }
}