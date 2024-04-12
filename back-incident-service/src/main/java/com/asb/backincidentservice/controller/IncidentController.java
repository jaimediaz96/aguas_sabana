package com.asb.backincidentservice.controller;

import com.asb.backincidentservice.business.interfaces.IncidentInterfaceBusiness;
import com.asb.backincidentservice.dto.request.IncidentRequestDto;
import com.asb.backincidentservice.dto.response.IncidentResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${application.request.mappings}/incident")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class IncidentController {
    private final IncidentInterfaceBusiness incidentInterfaceBusiness;

    @PostMapping("/create")
    public ResponseEntity<IncidentResponseDto> createTolls(@RequestBody IncidentRequestDto incidentRequestDto) {
        String messages = "The endpoint for create an incident is initiated, Object obtained-> " + incidentRequestDto;
        log.info(messages);

        IncidentResponseDto incidentResponseDto = this.incidentInterfaceBusiness.createIncident(incidentRequestDto);
        return ResponseEntity.ok().body(incidentResponseDto);
    }
}
