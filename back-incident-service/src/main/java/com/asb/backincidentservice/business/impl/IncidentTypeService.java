package com.asb.backincidentservice.business.impl;

import com.asb.backincidentservice.business.interfaces.IncidentTypeInterfaceBusiness;
import com.asb.backincidentservice.model.GgpIncidentType;
import com.asb.backincidentservice.repository.IncidentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class IncidentTypeService implements IncidentTypeInterfaceBusiness {
    private final IncidentTypeRepository incidentTypeRepository;

    @Override
    public List<GgpIncidentType> getAllIncidentTypes() {
        return (List<GgpIncidentType>) this.incidentTypeRepository.findAll();
    }
}
