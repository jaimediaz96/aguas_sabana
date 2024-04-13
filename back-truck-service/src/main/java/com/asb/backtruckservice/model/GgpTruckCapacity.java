package com.asb.backtruckservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ggp_truck_capacity")
public class GgpTruckCapacity {
    @Id
    @Column(name = "truck_capacity_id")
    private Long truckCapacityId;

    @Column(name = "capacity")
    private Double capacity;
}
