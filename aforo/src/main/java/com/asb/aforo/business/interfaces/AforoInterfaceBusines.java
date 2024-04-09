package com.asb.aforo.business.interfaces;

import com.asb.aforo.dto.request.AforoRequestDTO;
import com.asb.aforo.dto.response.AforoResponseDTO;
import com.asb.aforo.dto.response.AforoTypesResponseDTO;

import java.util.List;

public interface AforoInterfaceBusines {
    AforoResponseDTO createAforo(AforoRequestDTO request);

    List<AforoTypesResponseDTO>getAforoType();

}
