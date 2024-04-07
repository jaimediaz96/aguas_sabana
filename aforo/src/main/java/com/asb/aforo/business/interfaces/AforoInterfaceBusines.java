package com.asb.aforo.business.interfaces;

import com.asb.aforo.dto.request.AforoRequestDTO;
import com.asb.aforo.dto.response.AforoResponseDTO;

public interface AforoInterfaceBusines {
    AforoResponseDTO createAforo(AforoRequestDTO request);

}
