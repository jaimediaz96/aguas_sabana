package com.asb.aforo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotCollectedResponseDTO {

    private Long notCollectedId;

    private Long code;

    private String description;

}
