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
@Table(name = "ggp_truck_type")
public class GgpTruckType {
    @Id
    @Column(name = "truck_type_id")
    private Long truckTypeId;

    @Column(name = "type")
    private String type;
}
