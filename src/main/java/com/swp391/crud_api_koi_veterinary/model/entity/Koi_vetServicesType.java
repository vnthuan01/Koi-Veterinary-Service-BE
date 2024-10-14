package com.swp391.crud_api_koi_veterinary.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "service_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Koi_vetServicesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private int service_typeId;

    @Column(name = "service_type_name")
    private String service_typeName;

    @Column(name = "service_price")
    private BigDecimal price;
}
