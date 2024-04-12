package com.asb.backrefuelservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ggp_refuel")
public class GgpRefuel {
    @Id
    @SequenceGenerator(name = "SEQ-GGP-REFUEL", sequenceName = "seq_ggp_refuel", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-GGP-REFUEL")
    @Column(name = "refuel_id")
    private Long refuelId;

    @Column(name = "place")
    private String place;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "refuel_date")
    private LocalDateTime refuelDate;

    @Column(name = "refuel_time")
    private Long refuelTime;

    @Column(name = "micro_route_id")
    private Long microRouteId;
}
