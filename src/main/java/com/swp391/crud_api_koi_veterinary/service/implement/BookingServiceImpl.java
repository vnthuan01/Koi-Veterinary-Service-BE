package com.swp391.crud_api_koi_veterinary.service.implement;

import com.swp391.crud_api_koi_veterinary.enums.BookingStatus;
import com.swp391.crud_api_koi_veterinary.model.dto.request.BookingRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.*;
import com.swp391.crud_api_koi_veterinary.repository.*;
import com.swp391.crud_api_koi_veterinary.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ServicesDetailRepository servicesDetailRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final VeterinarianRepository veterinarianRepository;

    @Override
    public Booking createBooking(BookingRequest request, String username) {
        UserAccount user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ServicesDetail servicesDetail = servicesDetailRepository.findById(request.getServicesDetailId())
                .orElseThrow(() -> new RuntimeException("Services not found"));

        TimeSlot timeSlot = timeSlotRepository.findById(request.getSlotId())
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setServicesDetail(servicesDetail);
        booking.setSlot(timeSlot);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    @Override
    public List<ServicesDetail> getAvailableServices() {
        return servicesDetailRepository.findAllWithDetails();
    }

    @Override
    public List<TimeSlot> getAvailableTimeSlots() {
        return timeSlotRepository.findBySlotDateGreaterThanEqual(LocalDate.now());
    }

    @Override
    public List<String> getVeterinarian() {
        return veterinarianRepository.findVeterinarianFullNamesByServiceTypeId();
    }
}
