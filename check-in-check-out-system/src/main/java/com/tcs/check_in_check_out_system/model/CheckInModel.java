package com.tcs.check_in_check_out_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "check_in")
public class CheckInModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkInId;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Column(name = "status")
    private Boolean status = false;

    @Column(name = "employee_id")
    private Long employee;

    @OneToMany(mappedBy = "check", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) //Cascade to manage check-ins/ fetch =
    @JsonBackReference("check-location")
    private List<LocationModel> locationModels = new ArrayList<>();

//    @Column(name = "person")
//    private Long person;

}
