package com.asb.aforo.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AforoTypesResponseDTO {

    private Long aforoTypeId;
    private String name;

    public AforoTypesResponseDTO(Long aforoTypeId , String name){
        this.aforoTypeId = aforoTypeId;
        this.name = name;
    }
}
