package com.swp391.crud_api_koi_veterinary.model.dto.request;

import com.swp391.crud_api_koi_veterinary.enums.Role;
import lombok.Data;

@Data
public class StaffCreationRequest {
    private String fullname;
    private String password;
    private String phone;
    private String address;
    private Role role;
}
