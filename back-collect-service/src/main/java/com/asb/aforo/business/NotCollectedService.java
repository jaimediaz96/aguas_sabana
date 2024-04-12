package com.asb.aforo.business;

import com.asb.aforo.business.interfaces.NotCollectedInterfaceBusiness;
import com.asb.aforo.dto.response.NotCollectedResponseDTO;
import com.asb.aforo.model.GgpNotCollected;
import com.asb.aforo.repository.NotCollectedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NotCollectedService implements NotCollectedInterfaceBusiness {

    private final NotCollectedRepository notCollectedRepository;
    public GgpNotCollected insertNotcollectedTable(GgpNotCollected notCollected){
        return notCollectedRepository.save(notCollected);

    }

    @Override
    public List<NotCollectedResponseDTO> getNotCollected() {
        List<GgpNotCollected> notCollecteds = (List<GgpNotCollected>) notCollectedRepository.findAll();
        return notCollecteds.stream()
                .map(notCollected -> new NotCollectedResponseDTO(notCollected.getId(),notCollected.getCode(),notCollected.getDescription()))
                .collect(Collectors.toList());
    }
}
