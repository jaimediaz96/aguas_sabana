package com.asb.backtruckservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ggp_truck")
public class GgpTruck {
    @Id
    @SequenceGenerator(name = "SEQ-GGP-TRUCK", sequenceName = "seq_ggp_truck", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-GGP-TRUCK")
    @Column(name = "truck_id")
    private Long truckId;

    @Column(name = "plate")
    private String plate;

    @Column(name = "papers")
    private Boolean papers;

    @Column(name = "maintenance")
    private LocalDateTime maintenance;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "tire")
    private String tire;

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "fuel")
    private String fuel;

    @Column(name = "light")
    private String light;

    @Column(name = "honk")
    private String honk;

    @Column(name = "brake")
    private String brake;

    @Column(name = "oil")
    private String oil;

    @Column(name = "observation")
    private String observation;

    @Column(name = "truck_type_id")
    private String truckTypeId;

    @Column(name = "truck_capacity_id")
    private String truckCapacityId;
}
