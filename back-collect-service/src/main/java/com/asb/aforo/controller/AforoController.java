package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.AforoInterfaceBusines;
import com.asb.aforo.dto.request.AforoRequestDTO;
import com.asb.aforo.dto.response.AforoResponseDTO;
import com.asb.aforo.dto.response.AforoTypesResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/back-capacity-service/aforo-controller")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class AforoController {

    private final AforoInterfaceBusines aforoBusiness;
    @PostMapping("/create")
    public ResponseEntity<AforoResponseDTO>saveAforo(@RequestBody AforoRequestDTO request){
        log.info("Se inicia el endpoint para la creacion de un aforo Objeto obtenido-> {}",request);
        return new ResponseEntity<>(aforoBusiness.createAforo(request), HttpStatus.OK);
    }

    @GetMapping("/getTypes")
    public ResponseEntity<List<AforoTypesResponseDTO>>getAforoTypes(){
        log.info("Se inicia el endpoint para la obtencion de una lista de los tipos de aforo");
        return new ResponseEntity<>(aforoBusiness.getAforoType(),HttpStatus.OK);
    }

}
