package com.asb.backrefuelservice.controller;

import com.asb.backrefuelservice.business.interfaces.RefuelInterfaceBusiness;
import com.asb.backrefuelservice.dto.request.RefuelRequestDto;
import com.asb.backrefuelservice.dto.response.RefuelResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${application.request.mappings}/refuel")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class RefuelController {
    private final RefuelInterfaceBusiness refuelInterfaceBusiness;

    @PostMapping("/create")
    public ResponseEntity<RefuelResponseDto> createTolls(@RequestBody RefuelRequestDto refuelRequestDto) {
        String messages = "The endpoint for create an incident is initiated, Object obtained-> " + refuelRequestDto;
        log.info(messages);

        RefuelResponseDto refuelResponseDto = this.refuelInterfaceBusiness.createRefuel(refuelRequestDto);
        return ResponseEntity.ok().body(refuelResponseDto);
    }
}
