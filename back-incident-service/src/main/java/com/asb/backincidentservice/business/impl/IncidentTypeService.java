package com.asb.backincidentservice.business.impl;

import com.asb.backincidentservice.business.interfaces.IncidentTypeInterfaceBusiness;
import com.asb.backincidentservice.exception.GenericException;
import com.asb.backincidentservice.model.GgpIncidentType;
import com.asb.backincidentservice.repository.IncidentTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class IncidentTypeService implements IncidentTypeInterfaceBusiness {
    private final IncidentTypeRepository incidentTypeRepository;

    @Override
    public List<GgpIncidentType> getAllIncidentTypes() {
        List<GgpIncidentType> types = (List<GgpIncidentType>) this.incidentTypeRepository.findAll();

        if (types.isEmpty()) {
            log.error("No Incident types found in the database {}", types);
            throw new GenericException("No Incident types found in the database", HttpStatus.NOT_FOUND);
        }

        return types;
    }
}
