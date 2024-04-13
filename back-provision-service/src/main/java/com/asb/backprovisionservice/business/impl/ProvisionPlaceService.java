package com.asb.backprovisionservice.business.impl;

import com.asb.backprovisionservice.business.interfaces.ProvisionPlaceInterfaceBusiness;
import com.asb.backprovisionservice.exception.GenericException;
import com.asb.backprovisionservice.model.GgpProvisionPlace;
import com.asb.backprovisionservice.repository.ProvisionPlaceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProvisionPlaceService implements ProvisionPlaceInterfaceBusiness {
    private final ProvisionPlaceRepository provisionPlaceRepository;

    @Override
    public List<GgpProvisionPlace> getAllProvisionPlaces() {
        List<GgpProvisionPlace> places = (List<GgpProvisionPlace>) this.provisionPlaceRepository.findAll();

        if (places.isEmpty()) {
            log.error("No provision places found in the database {}", places);
            throw new GenericException("No provision places found in the database", HttpStatus.NOT_FOUND);
        }

        return places;
    }
}
