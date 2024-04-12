package com.asb.back_micro_route_business_service.controller;

import com.asb.back_micro_route_business_service.business.interfaces.CrewInterfaceBusiness;
import com.asb.back_micro_route_business_service.dto.response.CrewDTO;
import com.asb.back_micro_route_business_service.model.GgpCrew;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/back-micro-route-business-service/crew")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class CrewController {

    private final CrewInterfaceBusiness crewInterfaceBusiness;

    @GetMapping("/getCrew")
    public ResponseEntity<List<CrewDTO>>getCrew(){
        log.info("Inicia el endpoint getCrew");
        return new ResponseEntity<>(crewInterfaceBusiness.getCrew(), HttpStatus.OK);
    }
}
