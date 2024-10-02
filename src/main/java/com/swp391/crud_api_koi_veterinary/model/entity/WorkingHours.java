package com.swp391.crud_api_koi_veterinary.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "working_hours")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "working_hours_id")
    private Integer workingHoursId;

    @Column(name = "Monday", length = 50)
    private String monday;

    @Column(name = "Tuesday", length = 50)
    private String tuesday;

    @Column(name = "Wednesday", length = 50)
    private String wednesday;

    @Column(name = "Thursday", length = 50)
    private String thursday;

    @Column(name = "Friday", length = 50)
    private String friday;

    @Column(name = "Saturday", length = 50)
    private String saturday;

    @Column(name = "Sunday", length = 50)
    private String sunday;
}
