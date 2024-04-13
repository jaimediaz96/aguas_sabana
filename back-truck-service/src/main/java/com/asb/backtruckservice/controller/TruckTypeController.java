package com.asb.backtruckservice.controller;

import com.asb.backtruckservice.business.intefaces.TruckTypeInterfaceBusiness;
import com.asb.backtruckservice.model.GgpTruckType;
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
public class TruckTypeController {
    private final TruckTypeInterfaceBusiness truckTypeInterfaceBusiness;

    @GetMapping("/get-all")
    public ResponseEntity<List<GgpTruckType>> getAllTruckTypes() {
        log.info("The endpoint for obtaining a list of truck types is initiated");

        List<GgpTruckType> truckTypes = this.truckTypeInterfaceBusiness.getAllTruckTypes();
        return ResponseEntity.ok(truckTypes);
    }
}
