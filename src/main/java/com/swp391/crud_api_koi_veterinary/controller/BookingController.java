package com.swp391.crud_api_koi_veterinary.controller;

import com.swp391.crud_api_koi_veterinary.model.dto.request.BookingRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.Booking;
import com.swp391.crud_api_koi_veterinary.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest request, Authentication authentication) {
        String username = authentication.getName();
        Booking booking = bookingService.createBooking(request, username);
        return ResponseEntity.ok(booking);
    }
}