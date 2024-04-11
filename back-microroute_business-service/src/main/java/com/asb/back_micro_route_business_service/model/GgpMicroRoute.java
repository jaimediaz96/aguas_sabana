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
@Table(name="ggp_micro_route")
public class GgpMicroRoute {

    @Id
    @Column(name = "micro_route_id")
    private Long  microRouteId;

    @Column(name = "micro_route_name")
    private String  microRouteName;

    @Column(name = "micro_route_date_start")
    private LocalDateTime microRouteDateStart;

    @Column(name = "micro_route_date_finish")
    private LocalDateTime microRouteDateFinish;

    @Column(name = "milage")
    private Long milage;

    @Column(name = "micro_route_aforo_time")
    private Long microRouteAforoTime;

    @Column(name = "micro_route_trip_home_time")
    private Long microRouteTripHomeTime;

    @Column(name = "total_aforo")
    private Long  totalAforo;

    @Column(name = "density")
    private Double  density;

    @Column(name = "micro_route_sign")
    private String microRouteSign;

    @Column(name = "description_abandon")
    private String descriptionAbandon;

    @Column(name = "route_id")
    private Long  routeId;

    @Column(name = "user_id")
    private Long  userId;

    @Column(name = "truck_id")
    private Long  truckId;

    @Column(name = "state_micro_route_id")
    private Long  stateMicroRouteId;

}
