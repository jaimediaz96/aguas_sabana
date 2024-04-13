package com.asb.backtruckservice.dto.request;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TruckMileageRequestDto {
    private Long truckId;
    private Long mileage;
}
