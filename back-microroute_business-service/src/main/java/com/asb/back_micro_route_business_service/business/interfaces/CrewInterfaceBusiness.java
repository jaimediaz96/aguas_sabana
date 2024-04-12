package com.asb.back_micro_route_business_service.business.interfaces;

import com.asb.back_micro_route_business_service.dto.response.CrewDTO;
import com.asb.back_micro_route_business_service.model.GgpCrew;

import java.util.List;

public interface CrewInterfaceBusiness {

    List<CrewDTO> getCrew();

}
