package com.asb.back_micro_route_business_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ggp_micro_route_client")
public class GgpMicroRouteClient {

    @Column(name = "micro_route_id")
    private Long microRouteId;

    @Column(name = "client_id")
    private Long clientId;

    @Id
    @Column(name = "micro_route_client_id ")
    private Long microRouteClientId ;






}
