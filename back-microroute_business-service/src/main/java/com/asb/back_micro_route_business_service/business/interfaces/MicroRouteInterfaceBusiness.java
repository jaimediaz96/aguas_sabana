package com.asb.back_micro_route_business_service.business.interfaces;

import com.asb.back_micro_route_business_service.dto.response.DensityDTO;
import com.asb.back_micro_route_business_service.dto.response.GetMicroRouteResponseDTO;

public interface MicroRouteInterfaceBusiness {

    GetMicroRouteResponseDTO getMicroRouteByUserId(Long userId);

    DensityDTO getDensity(Long microRouteId);
}
