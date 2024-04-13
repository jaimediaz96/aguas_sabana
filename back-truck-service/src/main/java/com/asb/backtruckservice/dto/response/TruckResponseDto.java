package com.asb.backtruckservice.dto.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class TruckResponseDto {
    private Long truckId;
    private String plate;
    private Boolean papers;
    private LocalDateTime maintenance;
    private Long mileage;
    private String tire;
    private String pressure;
    private String fuel;
    private String light;
    private String honk;
    private String brake;
    private String oil;
    private String observation;
    private String type;
    private Double capacity;
}
