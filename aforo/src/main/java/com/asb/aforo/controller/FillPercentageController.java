package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.FillPercentageInterfaceBusiness;
import com.asb.aforo.dto.response.AforoTypesResponseDTO;
import com.asb.aforo.dto.response.FillPercentageResponseDTO;
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
@RequestMapping("/fillPercentage")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class FillPercentageController {

    private final FillPercentageInterfaceBusiness fillPercentageBusiness;

    @GetMapping("/getFillPercentage")
    public ResponseEntity<List<FillPercentageResponseDTO>> getFillPercentage(){
        log.info("Se inicia el endpoint para obtener los porcentajes de llenado");
        return new ResponseEntity<>(fillPercentageBusiness.getFillPercentage(), HttpStatus.OK);
    }

}
