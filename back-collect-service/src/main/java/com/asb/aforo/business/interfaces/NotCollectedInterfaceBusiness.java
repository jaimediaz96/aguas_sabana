package com.asb.aforo.business.interfaces;

import com.asb.aforo.dto.response.NotCollectedResponseDTO;
import com.asb.aforo.model.GgpNotCollected;

import java.util.List;

public interface NotCollectedInterfaceBusiness {

    GgpNotCollected insertNotcollectedTable(GgpNotCollected notCollected);
    List<NotCollectedResponseDTO> getNotCollected();
}
