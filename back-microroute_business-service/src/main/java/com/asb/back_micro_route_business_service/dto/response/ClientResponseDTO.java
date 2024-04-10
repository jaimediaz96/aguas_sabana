package com.asb.back_micro_route_business_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponseDTO {

    private Long clientId;
    private String companyName;
    private String address;
    private Long aforoId;
    private String aforoName;
}
