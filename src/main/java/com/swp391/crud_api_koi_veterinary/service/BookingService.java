package com.swp391.crud_api_koi_veterinary.service;

import com.swp391.crud_api_koi_veterinary.model.dto.request.BookingRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.Booking;

public interface BookingService {
    Booking createBooking(BookingRequest request, String username);
    
}
