package com.asb.back_micro_route_business_service.controller;

import com.asb.back_micro_route_business_service.business.interfaces.MicroRouteInterfaceBusiness;
import com.asb.back_micro_route_business_service.dto.response.DensityDTO;
import com.asb.back_micro_route_business_service.dto.response.GetMicroRouteResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/back-micro-route-business-service/micro-route")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class MicroRouteBusinessController {

    private final MicroRouteInterfaceBusiness microRouteBusiness;

    @GetMapping("/getByUserId/{userid}")
    public ResponseEntity<GetMicroRouteResponseDTO>getMicroRouteByUserId(@PathVariable("userid")Long userId){
        log.info("Se inicia el endpoint que busca una microruta y los clientes asociados al userId-> {}" , userId);
        return new ResponseEntity<>(microRouteBusiness.getMicroRouteByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/getDensity/{microRouteId}")
    public ResponseEntity<DensityDTO>getDensity(@PathVariable("microRouteId")Long microRouteId){
        log.info("Se inicia el endpoint que busca la densidad de una microruta -> {}" , microRouteId);
        return new ResponseEntity<>(microRouteBusiness.getDensity(microRouteId), HttpStatus.OK);
    }

}
