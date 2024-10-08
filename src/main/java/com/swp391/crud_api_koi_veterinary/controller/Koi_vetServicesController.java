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

    //API update
    @PutMapping("/{serviceId}")
    public Koi_vetServices updateService(@PathVariable int serviceId, @RequestBody Koi_vetServiceUpdateRequest request){
        return koi_vetService.updateService(serviceId, request);
    }

    //API delete
    @DeleteMapping("/{serviceId}")
    public String deleteService(@PathVariable int serviceId){
        koi_vetService.deleteService(serviceId);
        return "Service has been deleted";
    }

    //API lấy 1 service
    @GetMapping("/{serviceId}")
    public ResponseEntity<Optional<Koi_vetServices>>getServiceById(@PathVariable int serviceId) {
        Optional<Koi_vetServices> koiVetServices = koi_vetService.getServiceById(serviceId);
        return ResponseEntity.ok(koiVetServices);
    }

}
