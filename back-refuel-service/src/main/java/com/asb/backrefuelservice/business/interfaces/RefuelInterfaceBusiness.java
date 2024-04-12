package com.asb.backrefuelservice.business.interfaces;

import com.asb.backrefuelservice.dto.request.RefuelRequestDto;
import com.asb.backrefuelservice.dto.response.RefuelResponseDto;

public interface RefuelInterfaceBusiness {
    RefuelResponseDto createRefuel(RefuelRequestDto refuelRequestDto);
}
