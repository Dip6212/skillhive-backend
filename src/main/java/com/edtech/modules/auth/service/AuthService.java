package com.edtech.modules.auth.service;

import com.edtech.modules.auth.dto.LoginRequest;
import com.edtech.modules.auth.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
