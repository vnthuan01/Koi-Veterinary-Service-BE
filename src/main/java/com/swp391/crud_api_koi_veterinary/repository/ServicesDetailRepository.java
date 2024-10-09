package com.swp391.crud_api_koi_veterinary.repository;

import com.swp391.crud_api_koi_veterinary.model.entity.ServicesDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesDetailRepository extends JpaRepository<ServicesDetail, Integer> {
}
