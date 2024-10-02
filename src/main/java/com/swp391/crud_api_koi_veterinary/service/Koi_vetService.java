package com.swp391.crud_api_koi_veterinary.service;

import com.swp391.crud_api_koi_veterinary.repository.Koi_vetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Koi_vetService {
    private final Koi_vetRepository koi_vetRepository;


}
