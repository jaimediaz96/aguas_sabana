package com.asb.backrefuelservice.dto.request;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RefuelRequestDto {
    private String place;
    private Double quantity;
    private Double cost;
    private LocalDateTime refuelDate;
    private Long refuelTime;
    private Long microRouteId;
}
