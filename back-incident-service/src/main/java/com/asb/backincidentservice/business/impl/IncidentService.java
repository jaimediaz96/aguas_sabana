package com.asb.backincidentservice.business.impl;

import com.asb.backincidentservice.business.interfaces.IncidentInterfaceBusiness;
import com.asb.backincidentservice.dto.request.IncidentRequestDto;
import com.asb.backincidentservice.dto.response.IncidentResponseDto;
import com.asb.backincidentservice.exception.GenericException;
import com.asb.backincidentservice.model.GgpIncident;
import com.asb.backincidentservice.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class IncidentService implements IncidentInterfaceBusiness {
    private final IncidentRepository incidentRepository;

    @Override
    @Transactional
    public IncidentResponseDto createIncident(IncidentRequestDto incidentRequestDto) {
        IncidentResponseDto incidentResponseDto = new IncidentResponseDto();

        GgpIncident incident = new GgpIncident();

        try {
            incident.setDescription(requireNonNull(incidentRequestDto.getDescription(), "description"));
            incident.setIncidentDate(requireNonNull(incidentRequestDto.getIncidentDate(), "incidentDate"));
            incident.setIncidentTime(requireNonNull(incidentRequestDto.getIncidentTime(), "incidentTime"));
            incident.setMicroRouteId(requireNonNull(incidentRequestDto.getMicroRouteId(), "microRouteId"));
            incident.setIncidentTypeId(requireNonNull(incidentRequestDto.getIncidentTypeId(), "incidentTypeId"));

            incident = this.incidentRepository.save(incident);

            String messages = "The incident -> { " + incident + " } was save in the entity GgpIncident";
            log.info(messages);
        } catch (NullPointerException e) {
            log.error("missing variable: {}", e.getMessage());
            throw new GenericException("missing variable: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error at create incident");
            log.error("Causa of error at create incident -> {}", e.getCause().toString());
            log.error("Messages of error at create incident -> {}", e.getMessage());
            throw new GenericException("It cant create incident", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        incidentResponseDto.setIncidentId(incident.getIncidentId());

        return incidentResponseDto;
    }
}
