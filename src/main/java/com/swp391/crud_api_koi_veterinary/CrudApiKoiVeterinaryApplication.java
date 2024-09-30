package com.swp391.crud_api_koi_veterinary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.swp391.crud_api_koi_veterinary"})
public class CrudApiKoiVeterinaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApiKoiVeterinaryApplication.class, args);
    }

}
