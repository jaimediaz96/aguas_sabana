package com.asb.backprovisionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ggp_provision")
public class GgpProvision {
    @Id
    @SequenceGenerator(name = "SEQ-GGP-PROVISION", sequenceName = "SEQ_GGP_PROVISION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-GGP-PROVISION")
    @Column(name = "provision_id")
    private Long provisionId;

    @Column(name = "km_start")
    private Long kmStart;

    @Column(name = "km_finish")
    private Long kmFinish;

    @Column(name = "provision_date")
    private LocalDateTime provisionDate;

    @Column(name = "provision_time_trip")
    private Long provisionTimeTrip;

    @Column(name = "provision_time_Place")
    private Long provisionTimePlace;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "micro_route_id")
    private Long microRouteId;

    @Column(name = "provision_place_id")
    private Long provisionPlaceId;

    @Column(name = "provision_type_id")
    private Long provisionTypeId;
}