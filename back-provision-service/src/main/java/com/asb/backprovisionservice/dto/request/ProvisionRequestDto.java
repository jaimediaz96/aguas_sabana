package com.asb.backprovisionservice.dto.request;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProvisionRequestDto {
    private Long kmStart;
    private Long kmFinish;
    private LocalDateTime provisionDate;
    private Long provisionTimeTrip;
    private Long provisionTimePlace;
    private Double weight;
    private Long microRouteId;
    private Long provisionPlaceId;
    private Long provisionTypeId;
    private List<Long> tollIds;
}
