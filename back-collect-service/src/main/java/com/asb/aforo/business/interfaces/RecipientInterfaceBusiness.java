package com.asb.aforo.business.interfaces;

import com.asb.aforo.dto.response.ObjectResponse;
import com.asb.aforo.dto.response.RecipientTypeResponseDTO;
import com.asb.aforo.model.GgpRecipient;

import java.util.List;

public interface RecipientInterfaceBusiness {

    List<RecipientTypeResponseDTO>getRecipientType();
    ObjectResponse saveRecipient(List<GgpRecipient> recipients, Long aforoId);
}
