package com.authservice.authservice.controller;

import com.authservice.authservice.dto.request.LoginRequest;
import com.authservice.authservice.dto.request.SignupRequest;
import com.authservice.authservice.dto.response.AuthResponse;
import com.authservice.authservice.dto.response.SignupResponse;
import com.authservice.authservice.dto.response.UserResponse;
import com.authservice.authservice.service.UserService;
import com.authservice.authservice.utils.constants.Route;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(Route.USER_BASE_PATH)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(Route.HELLO_PATH)
    public ResponseEntity<String> welcomeMessage() {
        return ResponseEntity.ok("Hello from GreenStitch");
    }

    @PostMapping(Route.SIGNUP_PATH)
    public ResponseEntity<SignupResponse> register(@Valid @RequestBody SignupRequest request) {
        return ResponseEntity.ok(userService.signup(request));
    }

    @PostMapping(Route.LOGIN_PATH)
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam("email") String email) {
        UserResponse userResponse = userService.getUserByEmail(email);
        return ResponseEntity.ok(userResponse);
    }
}