package com.asb.aforo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecipientTypeResponseDTO {

    private Long recipient_type_id;

    private String name;

    private Double recipient_value;

    private Long aforo_type_id;
}
