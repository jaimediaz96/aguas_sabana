package com.asb.backprovisionservice.controller;

import com.asb.backprovisionservice.business.interfaces.TollInterfaceBusiness;
import com.asb.backprovisionservice.dto.request.TollRequestDto;
import com.asb.backprovisionservice.dto.response.TollResponseDto;
import com.asb.backprovisionservice.model.GgpToll;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("${application.request.mappings}/toll")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TollController {
    private final TollInterfaceBusiness tollInterfaceBusiness;

    @GetMapping("/get-all")
    public ResponseEntity<List<GgpToll>> getAllTolls() {
        log.info("The endpoint is started to get all of toll");

        List<GgpToll> tolls = this.tollInterfaceBusiness.getAllTolls();
        return ResponseEntity.ok().body(tolls);
    }

    @PostMapping("/create")
    public ResponseEntity<TollResponseDto> createTolls(@RequestBody TollRequestDto tollRequestDto) {
        String messages = "The endpoint for create a toll is initiated, Object obtained-> " + tollRequestDto;
        log.info(messages);

        TollResponseDto tollResponseDto = this.tollInterfaceBusiness.createTolls(tollRequestDto);
        return ResponseEntity.ok().body(tollResponseDto);
    }
}
