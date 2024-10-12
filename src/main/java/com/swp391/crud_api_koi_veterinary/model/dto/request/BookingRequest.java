package com.swp391.crud_api_koi_veterinary.model.dto.request;

import lombok.Data;

@Data
public class BookingRequest {
    private Integer servicesDetailId;
    private Integer slotId;
    private Integer veterinarianId;
}
