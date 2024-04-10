package com.asb.aforo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FillPercentageResponseDTO {

    private Long fillPercentageId;

    private Float percent;
}
