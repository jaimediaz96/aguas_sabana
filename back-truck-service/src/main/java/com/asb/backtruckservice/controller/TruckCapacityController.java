package com.asb.backtruckservice.controller;

import com.asb.backtruckservice.business.intefaces.TruckCapacityInterfaceBusiness;
import com.asb.backtruckservice.model.GgpTruckCapacity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${application.request.mappings}/capacity")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TruckCapacityController {
    private final TruckCapacityInterfaceBusiness truckCapacityInterfaceBusiness;

    @GetMapping("/get-all")
    public ResponseEntity<List<GgpTruckCapacity>> getAllTruckCapacities() {
        log.info("The endpoint for obtaining a list of truck capacities is initiated");

        List<GgpTruckCapacity> truckCapacities = this.truckCapacityInterfaceBusiness.getAllTruckCapacity();
        return ResponseEntity.ok(truckCapacities);
    }
}
