package com.asb.back_micro_route_business_service.business.interfaces;

import com.asb.back_micro_route_business_service.dto.request.MicroRouteRequestDTO;
import com.asb.back_micro_route_business_service.dto.response.DensityDTO;
import com.asb.back_micro_route_business_service.dto.response.GetMicroRouteResponseDTO;
import com.asb.back_micro_route_business_service.dto.response.ObjectResponse;

public interface MicroRouteInterfaceBusiness {

    GetMicroRouteResponseDTO getMicroRouteByUserId(Long userId);

    DensityDTO getDensity(Long microRouteId);

    ObjectResponse updateMicroRoute(Long microRouteId, MicroRouteRequestDTO request);
}
