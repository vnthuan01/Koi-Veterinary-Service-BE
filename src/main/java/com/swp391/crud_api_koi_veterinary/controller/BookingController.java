package com.swp391.crud_api_koi_veterinary.controller;

import com.swp391.crud_api_koi_veterinary.model.dto.request.BookingRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.Booking;
import com.swp391.crud_api_koi_veterinary.model.entity.ServicesDetail;
import com.swp391.crud_api_koi_veterinary.model.entity.TimeSlot;
import com.swp391.crud_api_koi_veterinary.model.entity.Veterinarian;
import com.swp391.crud_api_koi_veterinary.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/services")
    public ResponseEntity<List<ServicesDetail>> getAvailableServices() {
        List<ServicesDetail> services = bookingService.getAvailableServices();
        return ResponseEntity.ok(services);
    }

    @GetMapping("/timeslots")
    public ResponseEntity<List<TimeSlot>> getAvailableTimeSlots() {
        List<TimeSlot> timeSlots = bookingService.getAvailableTimeSlots();
        return ResponseEntity.ok(timeSlots);
    }

    @GetMapping("/veterinarians")
    public ResponseEntity<List<Veterinarian>> getVeterinarian() {
        List<Veterinarian> veterinarians = bookingService.getVeterinarian();
        return ResponseEntity.ok(veterinarians);
    }
}