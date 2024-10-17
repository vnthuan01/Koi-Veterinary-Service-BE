package com.swp391.crud_api_koi_veterinary.model.entity;

import com.swp391.crud_api_koi_veterinary.enums.ServiceType;
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
public class ServicesType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private int service_typeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_type")
    private ServiceType service_type;

    @Column(name = "service_price")
    private BigDecimal price;
}
