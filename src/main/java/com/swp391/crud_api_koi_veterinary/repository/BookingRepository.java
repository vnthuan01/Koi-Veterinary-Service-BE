package com.swp391.crud_api_koi_veterinary.repository;

import com.swp391.crud_api_koi_veterinary.enums.BookingStatus;
import com.swp391.crud_api_koi_veterinary.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // Tìm tất cả các booking của một người dùng cụ thể
    List<Booking> findByUserUsername(String username);

    // Tìm tất cả các booking của một bác sĩ thú y cụ thể
    List<Booking> findByVeterinarianUsername(String username);

    // Tìm tất cả các booking theo trạng thái
    List<Booking> findByStatus(BookingStatus status);

    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh khác nếu cần
}
