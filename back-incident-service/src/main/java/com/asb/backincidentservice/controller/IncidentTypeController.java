package com.asb.backincidentservice.controller;

import com.asb.backincidentservice.business.interfaces.IncidentTypeInterfaceBusiness;
import com.asb.backincidentservice.model.GgpIncidentType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${application.request.mappings}/type")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class IncidentTypeController {
    private final IncidentTypeInterfaceBusiness incidentTypeInterfaceBusiness;

    @GetMapping("/get-all")
    public ResponseEntity<List<GgpIncidentType>> getAllIncidentTypes() {
        log.info("The endpoint for obtaining a list of incident types is initiated");

        List<GgpIncidentType> incidentTypes = this.incidentTypeInterfaceBusiness.getAllIncidentTypes();
        return ResponseEntity.ok(incidentTypes);
    }
}
