package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.AforoInterfaceBusines;
import com.asb.aforo.dto.request.AforoRequestDTO;
import com.asb.aforo.dto.request.PhotosDTO;
import com.asb.aforo.dto.response.AforoResponseDTO;
import com.asb.aforo.dto.response.ObjectResponse;
import com.asb.aforo.model.GgpAforo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aforo")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class AforoController {

    private final AforoInterfaceBusines aforoBusiness;
    @PostMapping("/create")
    public ResponseEntity<AforoResponseDTO>saveAforo(@RequestBody AforoRequestDTO request){
        log.info("Se inicia el endpoint para la creacion de un aforo Objeto obtenido-> {}",request);
        return new ResponseEntity<>(aforoBusiness.createAforo(request), HttpStatus.OK);
    }

}
