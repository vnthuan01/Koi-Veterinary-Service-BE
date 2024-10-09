package com.swp391.crud_api_koi_veterinary.service.implement;

import com.swp391.crud_api_koi_veterinary.enums.BookingStatus;
import com.swp391.crud_api_koi_veterinary.model.dto.request.BookingRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.*;
import com.swp391.crud_api_koi_veterinary.repository.*;
import com.swp391.crud_api_koi_veterinary.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ServicesDetailRepository servicesDetailRepository;
    private final TimeSlotRepository timeSlotRepository;

    @Override
    public Booking createBooking(BookingRequest request, String username) {
        UserAccount user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

        ServicesDetail servicesDetail = servicesDetailRepository.findById(request.getServicesDetailId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chi tiết dịch vụ"));

        UserAccount veterinarian = userRepository.findById(request.getVeterinarianId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ thú y"));

        TimeSlot timeSlot = timeSlotRepository.findById(request.getSlotId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khung giờ"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setServicesDetail(servicesDetail);
        booking.setVeterinarian(veterinarian);
        booking.setSlot(timeSlot);
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    // Triển khai các phương thức khác nếu có
}
