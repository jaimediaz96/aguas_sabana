package com.asb.backtruckservice.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TruckPlatesResponseDto {
    private Long truckId;
    private String plate;
}
