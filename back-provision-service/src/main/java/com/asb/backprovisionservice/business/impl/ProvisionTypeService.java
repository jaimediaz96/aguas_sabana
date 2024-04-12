package com.asb.backprovisionservice.business.impl;

import com.asb.backprovisionservice.business.interfaces.ProvisionTypeInterfaceBusiness;
import com.asb.backprovisionservice.model.GgpProvisionType;
import com.asb.backprovisionservice.repository.ProvisionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProvisionTypeService implements ProvisionTypeInterfaceBusiness {
    private final ProvisionTypeRepository provisionTypeRepository;

    @Override
    public List<GgpProvisionType> getAllProvisionTypes() {
        return (List<GgpProvisionType>) this.provisionTypeRepository.findAll();
    }
}
