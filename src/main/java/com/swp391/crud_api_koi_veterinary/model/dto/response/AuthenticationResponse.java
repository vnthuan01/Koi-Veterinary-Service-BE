package com.swp391.crud_api_koi_veterinary.model.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String accessToken;
    private String role;
    private LocalDateTime finishTime;
}