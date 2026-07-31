package com.edtech.modules.auth.service.impl;

import com.edtech.modules.auth.dto.LoginRequest;
import com.edtech.modules.auth.dto.LoginResponse;
import com.edtech.modules.auth.entity.Admin;
import com.edtech.modules.auth.mapper.AdminMapper;
import com.edtech.modules.auth.repository.AdminRepository;
import com.edtech.modules.auth.service.AuthService;
import com.edtech.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final AdminRepository adminRepository;

    private final JwtService jwtService;

    private final AdminMapper adminMapper;

    @Override
    public LoginResponse login(LoginRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        Admin admin = adminRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Admin not found")
                );

        String accessToken =
                jwtService.generateToken(admin.getEmail());

        return LoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(null)
                .admin(adminMapper.toAdminResponse(admin))
                .build();
    }
}