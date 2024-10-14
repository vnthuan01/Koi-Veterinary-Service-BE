package com.swp391.crud_api_koi_veterinary.service;

import com.swp391.crud_api_koi_veterinary.model.dto.request.Koi_vetServiceCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.request.Koi_vetServiceUpdateRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.Koi_vetServices;
import com.swp391.crud_api_koi_veterinary.repository.Koi_vetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class Koi_vetService{
    @Autowired
    private final Koi_vetRepository koi_vetRepository;

//1. Tạo 1 Service
    public Koi_vetServices createService(Koi_vetServiceCreationRequest request) {
        Koi_vetServices service = new Koi_vetServices();
        service.setServiceName(request.getServiceName());
        service.setServiceDescription(request.getServiceDescription());
        return koi_vetRepository.save(service);
    }

//2. Lấy danh sách Services
    public List<Koi_vetServices> getAllServices() {
        return koi_vetRepository.findAll();
    }

    //3. Update 1 Service theo Id
    public Koi_vetServices updateService(int serviceId, Koi_vetServiceUpdateRequest request) {
        Koi_vetServices service = koi_vetRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        
        // Cập nhật tên dịch vụ nếu có giá trị mới
        if (request.getServiceName() != null && !request.getServiceName().isEmpty()) {
            service.setServiceName(request.getServiceName());
        }
        
        // Cập nhật mô tả dịch vụ nếu có giá trị mới
        if (request.getServiceDescription() != null && !request.getServiceDescription().isEmpty()) {
            service.setServiceDescription(request.getServiceDescription());
        }
        
        return koi_vetRepository.save(service);
    }

    //4. Xóa 1 Service theo Id
    public void deleteService(int serviceId) {
        koi_vetRepository.deleteById(serviceId);
    }

    //5. Lấy 1 Service theo Id
    public Optional<Koi_vetServices> getServiceById(int serviceId) {
        return Optional.ofNullable(koi_vetRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found")));
    }
}
