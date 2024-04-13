package com.asb.back_micro_route_business_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MicroRouteRequestDTO {

    private LocalDateTime dateFinish;
    private Long milage;
    private Long microRouteAforoTime;
    private Long microRouteTripHomeTime;
    private Double totalAforo;
    private Double density;
    private String descriptionAbandon;

}
