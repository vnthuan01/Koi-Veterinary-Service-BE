package com.swp391.crud_api_koi_veterinary.controller;

import com.swp391.crud_api_koi_veterinary.model.dto.request.UserCreationRequest;
import com.swp391.crud_api_koi_veterinary.model.entity.UserAccount;
import com.swp391.crud_api_koi_veterinary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("local")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
//Tạo 1 account
    @PostMapping("/users")
    UserAccount createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
//lấy danh sách các account
    @GetMapping("/users")
    List<UserAccount> getUserAccount(){
        return userService.getUserAccount();
    }
//lấy thông tin cá nhân
    @GetMapping("/{userId}")
    UserAccount getUserProfile(@PathVariable("userId") int userId){
        return userService.getUserInfo(userId);
    }
//Xóa 1 account
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable int userId){
        userService.deleteAccount(userId);
        return "User has been deleted";
    }
}