package com.swp391.crud_api_koi_veterinary.controller;

import com.swp391.crud_api_koi_veterinary.model.dto.request.StaffCreationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.crud_api_koi_veterinary.model.dto.request.AuthenticationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.request.UserCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.response.AuthenticationResponse;
import com.swp391.crud_api_koi_veterinary.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> usernamePasswordAuthentication(
            @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authService.localAuthentication(authenticationRequest));
    }
    
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserCreationRequest registerRequest) {
        return ResponseEntity.ok(authService.registerAuthentication(registerRequest));
    }
    
    @PostMapping("addstaff")
    public ResponseEntity<AuthenticationResponse> createStaff(@RequestBody StaffCreationRequest staffRequest) {
        return ResponseEntity.ok(authService.createStaffAuthentication(staffRequest));
    }
}