package com.swp391.crud_api_koi_veterinary.controller;

import com.swp391.crud_api_koi_veterinary.model.dto.request.UserCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.dto.request.UserUpdateRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.UserAccount;
import com.swp391.crud_api_koi_veterinary.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class UserController {

    private final CustomerService customerService;

    @PostMapping
    public UserAccount createUser(@RequestBody UserCreationRequest request) {
        return customerService.createUser(request);}

    @GetMapping
    public List<UserAccount> getUserAccounts() {
        return customerService.getUserAccount();
    }

    @GetMapping("/{userId}")
    public UserAccount getUserProfile(@PathVariable int userId) {
        return customerService.getUserInfo(userId);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        customerService.deleteAccount(userId);
        return "User has been deleted";
    }
//Update API
    @PutMapping({"/{userId}"})
    UserAccount updateUser(@PathVariable int userId, @RequestBody UserUpdateRequest request){
        return customerService.updateUser(userId, request);
    }
}