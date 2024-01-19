package com.authservice.authservice.service;

import com.authservice.authservice.dto.request.LoginRequest;
import com.authservice.authservice.dto.request.SignupRequest;
import com.authservice.authservice.dto.response.AuthResponse;
import com.authservice.authservice.dto.response.SignupResponse;
import com.authservice.authservice.dto.response.UserResponse;

public interface UserService {
    SignupResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);

    UserResponse getUserByEmail(String email);

}
