package com.asb.backincidentservice.dto.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class IncidentRequestDto {
    private String description;
    private LocalDateTime incidentDate;
    private Long incidentTime;
    private Long microRouteId;
    private Long incidentTypeId;
}
