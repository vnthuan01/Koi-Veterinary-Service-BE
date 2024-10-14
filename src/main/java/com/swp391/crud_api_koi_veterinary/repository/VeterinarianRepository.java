package com.swp391.crud_api_koi_veterinary.repository;

import com.swp391.crud_api_koi_veterinary.model.entity.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Integer> {
    
    @Query("SELECT v.user.fullname FROM Veterinarian v WHERE v.serviceTypeId.id = 1")
    List<String> findVeterinarianFullNamesByServiceTypeId();
}
