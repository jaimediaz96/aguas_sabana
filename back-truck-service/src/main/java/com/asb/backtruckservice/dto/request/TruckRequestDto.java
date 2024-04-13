package com.asb.backtruckservice.dto.request;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TruckRequestDto {
    private Long truckId;
    private String plate;
    private Boolean papers;
    private Long mileage;
    private String tire;
    private String pressure;
    private String fuel;
    private String light;
    private String honk;
    private String brake;
    private String oil;
    private String observation;
}
