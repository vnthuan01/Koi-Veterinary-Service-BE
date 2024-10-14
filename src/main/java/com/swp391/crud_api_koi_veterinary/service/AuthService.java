package com.swp391.crud_api_koi_veterinary.service;

import com.swp391.crud_api_koi_veterinary.model.dto.request.AuthenticationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.request.StaffCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.response.AuthenticationResponse;
import com.swp391.crud_api_koi_veterinary.model.dto.request.UserCreationRequest;

public interface AuthService {
    AuthenticationResponse localAuthentication(AuthenticationRequest request);
    AuthenticationResponse registerAuthentication(UserCreationRequest request);
    AuthenticationResponse createStaffAuthentication(StaffCreationRequest request);
}