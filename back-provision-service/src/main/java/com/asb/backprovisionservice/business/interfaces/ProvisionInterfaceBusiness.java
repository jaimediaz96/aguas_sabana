package com.asb.backprovisionservice.business.interfaces;

import com.asb.backprovisionservice.dto.request.ProvisionRequestDto;
import com.asb.backprovisionservice.dto.response.ProvisionResponseDto;

public interface ProvisionInterfaceBusiness {
    ProvisionResponseDto createProvision(ProvisionRequestDto provisionRequestDto);
}
