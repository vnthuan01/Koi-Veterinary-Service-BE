package com.swp391.crud_api_koi_veterinary.model.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreationRequest {
    private String username;

    private String password;

    private String email;

    private String phone;

    private String address;

    private String firstName;

    private String lastName;
    // Bỏ trường role vì chúng ta sẽ đặt mặc định là "CUSTOMER"
}
