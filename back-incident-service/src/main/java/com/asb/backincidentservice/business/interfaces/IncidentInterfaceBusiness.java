package com.asb.backincidentservice.business.interfaces;

import com.asb.backincidentservice.dto.request.IncidentRequestDto;
import com.asb.backincidentservice.dto.response.IncidentResponseDto;

public interface IncidentInterfaceBusiness {
    IncidentResponseDto createIncident(IncidentRequestDto incidentRequestDto);
}
