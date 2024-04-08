package com.asb.aforo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class AforoTypesResponseDTO {

    private Long aforoTypeId;
    private String name;

}
