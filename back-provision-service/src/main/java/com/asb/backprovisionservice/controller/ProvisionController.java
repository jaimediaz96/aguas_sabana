package com.asb.backprovisionservice.controller;

import com.asb.backprovisionservice.business.interfaces.ProvisionInterfaceBusiness;
import com.asb.backprovisionservice.dto.request.ProvisionRequestDto;
import com.asb.backprovisionservice.dto.response.ProvisionResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${application.request.mappings}/provision")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProvisionController {
    private final ProvisionInterfaceBusiness provisionInterfaceBusiness;

    @PostMapping("/create")
    public ResponseEntity<ProvisionResponseDto> saveProvision(@RequestBody ProvisionRequestDto provisionRequestDto) {
        String messages = "The endpoint for create a provision is initiated, Object obtained-> " + provisionRequestDto;
        log.info(messages);

        ProvisionResponseDto provisionResponseDto = this.provisionInterfaceBusiness.createProvision(provisionRequestDto);
        return ResponseEntity.ok(provisionResponseDto);
    }
}
