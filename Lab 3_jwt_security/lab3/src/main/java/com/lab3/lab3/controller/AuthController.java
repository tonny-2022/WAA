package com.lab3.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lab3.lab3.entity.dto.LoginRequest;
import com.lab3.lab3.entity.dto.LoginResponse;
import com.lab3.lab3.entity.dto.RefreshTokenRequest;
import com.lab3.lab3.service.AuthService;

//@RestController
@RequestMapping("/api/v3/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private  AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }

}