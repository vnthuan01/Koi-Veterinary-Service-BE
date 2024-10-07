package com.swp391.crud_api_koi_veterinary.controller;


import com.swp391.crud_api_koi_veterinary.model.dto.request.Koi_vetServiceCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.request.Koi_vetServiceUpdateRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.Koi_vetServices;
import com.swp391.crud_api_koi_veterinary.service.Koi_vetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class Koi_vetServicesController {
    private final Koi_vetService koi_vetService;

    //API tạo 1 service
    @PostMapping
    public Koi_vetServices createService(@RequestBody Koi_vetServiceCreationRequest request){
        return koi_vetService.createService(request);
    }

    //API lấy danh sách services
    @GetMapping
    public List<Koi_vetServices> listServices(){
        return koi_vetService.getAllServices();
    }



}
