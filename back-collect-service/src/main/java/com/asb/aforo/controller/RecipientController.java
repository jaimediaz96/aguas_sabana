package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.RecipientInterfaceBusiness;
import com.asb.aforo.dto.response.AforoTypesResponseDTO;
import com.asb.aforo.dto.response.RecipientTypeResponseDTO;
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
@RequestMapping("/api/v1/back-capacity-service/recipient")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class RecipientController {

    private final RecipientInterfaceBusiness recipientBusinessInterface;

    @GetMapping("/getRecipientType")
    public ResponseEntity<List<RecipientTypeResponseDTO>> getAforoTypes(){
        log.info("Se inicia el endpoint para la obtencion de una lista de los tipos de recipientes");
        return new ResponseEntity<>(recipientBusinessInterface.getRecipientType(), HttpStatus.OK);
    }

}
