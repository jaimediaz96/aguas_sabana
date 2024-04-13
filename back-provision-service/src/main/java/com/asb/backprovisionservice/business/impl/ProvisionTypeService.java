package com.asb.backprovisionservice.business.impl;

import com.asb.backprovisionservice.business.interfaces.ProvisionTypeInterfaceBusiness;
import com.asb.backprovisionservice.exception.GenericException;
import com.asb.backprovisionservice.model.GgpProvisionType;
import com.asb.backprovisionservice.repository.ProvisionTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProvisionTypeService implements ProvisionTypeInterfaceBusiness {
    private final ProvisionTypeRepository provisionTypeRepository;

    @Override
    public List<GgpProvisionType> getAllProvisionTypes() {
        List<GgpProvisionType> types = (List<GgpProvisionType>) this.provisionTypeRepository.findAll();

        if (types.isEmpty()) {
            log.error("No provision types found in the database {}", types);
            throw new GenericException("No provision types found in the database", HttpStatus.NOT_FOUND);
        }

        return types;
    }
}
