package com.asb.backprovisionservice.business.interfaces;

import com.asb.backprovisionservice.dto.request.TollRequestDto;
import com.asb.backprovisionservice.dto.response.TollResponseDto;
import com.asb.backprovisionservice.model.GgpToll;
import java.util.List;

public interface TollInterfaceBusiness {
    TollResponseDto createTolls(TollRequestDto tollRequestDto);
    List<GgpToll> getAllTolls();
}
