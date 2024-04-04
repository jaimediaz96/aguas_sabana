package com.asb.aforo.business;

import com.asb.aforo.business.interfaces.NotCollectedInterfaceBusiness;
import com.asb.aforo.model.GgpNotCollected;
import com.asb.aforo.repository.NotCollectedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NotCollectedService implements NotCollectedInterfaceBusiness {

    private final NotCollectedRepository notCollectedRepository;
    public GgpNotCollected insertNotcollectedTable(GgpNotCollected notCollected){
        return notCollectedRepository.save(notCollected);

    }
}
