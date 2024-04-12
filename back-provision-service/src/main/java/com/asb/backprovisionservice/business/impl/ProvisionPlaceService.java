package com.asb.backprovisionservice.business.impl;

import com.asb.backprovisionservice.business.interfaces.ProvisionPlaceInterfaceBusiness;
import com.asb.backprovisionservice.model.GgpProvisionPlace;
import com.asb.backprovisionservice.repository.ProvisionPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProvisionPlaceService implements ProvisionPlaceInterfaceBusiness {
    private final ProvisionPlaceRepository provisionPlaceRepository;

    @Override
    public List<GgpProvisionPlace> getAllProvisionPlaces() {
        return (List<GgpProvisionPlace>) this.provisionPlaceRepository.findAll();
    }
}
