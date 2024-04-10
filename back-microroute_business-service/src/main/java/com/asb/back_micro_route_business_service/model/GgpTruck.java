package com.asb.back_micro_route_business_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ggp_truck")
public class GgpTruck {

    @Id
    @Column(name = "truck_id")
    private Long truckId;

    @Column(name = "plate")
    private Long plate;

    @Column(name = "papers")
    private Long papers;

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
    private Long truckTypeId;

    @Column(name = "truck_capacity_id ")
    private Long truckCapacityId ;


}
