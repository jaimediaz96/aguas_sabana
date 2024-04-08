package com.asb.aforo.business;

import com.asb.aforo.business.interfaces.FillPercentageInterfaceBusiness;
import com.asb.aforo.dto.response.FillPercentageResponseDTO;
import com.asb.aforo.model.GgpFillPercentage;
import com.asb.aforo.repository.FillPercentageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class FillPercentageService implements FillPercentageInterfaceBusiness {

    private final FillPercentageRepository fillPercentageRepository;
    @Override
    public List<FillPercentageResponseDTO> getFillPercentage() {
        List<GgpFillPercentage> fillPercentages = (List<GgpFillPercentage>) fillPercentageRepository.findAll();
        return fillPercentages.stream()
                .map(fillPercentage -> new FillPercentageResponseDTO(fillPercentage.getFill_percentage_id(),fillPercentage.getPercent()))
                .collect(Collectors.toList());
    }
}
