package com.asb.back_micro_route_business_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMicroRouteResponseDTO {

    private Long microRouteId;
    private String routeName;
    private String routeDescription;
    private String name;
    private String plate;
    private List<ClientResponseDTO>clients;
}
