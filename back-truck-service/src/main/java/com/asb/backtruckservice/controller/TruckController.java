package com.asb.backtruckservice.controller;

import com.asb.backtruckservice.business.intefaces.TruckInterfaceBusiness;
import com.asb.backtruckservice.dto.request.TruckIdRequestDto;
import com.asb.backtruckservice.dto.request.TruckMileageRequestDto;
import com.asb.backtruckservice.dto.request.TruckPlateRequestDto;
import com.asb.backtruckservice.dto.request.TruckRequestDto;
import com.asb.backtruckservice.dto.response.TruckIdResponseDto;
import com.asb.backtruckservice.dto.response.TruckPlatesResponseDto;
import com.asb.backtruckservice.dto.response.TruckResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("${application.request.mappings}/truck")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TruckController {
    private final TruckInterfaceBusiness truckInterfaceBusiness;

    @GetMapping("/get-all-plates")
    public ResponseEntity<List<TruckPlatesResponseDto>> getAllPlates() {
        log.info("The endpoint for obtaining a list of truck plates is initiated");

        List<TruckPlatesResponseDto> truckPlatesResponseDts = this.truckInterfaceBusiness.getAllTruckPlates();
        return ResponseEntity.ok(truckPlatesResponseDts);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<TruckResponseDto> getById(@RequestBody TruckIdRequestDto truckIdRequestDto) {
        String message = "The endpoint for obtaining a truck by id is initiated, Object obtained -> " + truckIdRequestDto;
        log.info(message);

        TruckResponseDto truckResponseDto = this.truckInterfaceBusiness.getTruckById(truckIdRequestDto);
        return ResponseEntity.ok(truckResponseDto);
    }

    @GetMapping("/get-truckId-by-Plate")
    public ResponseEntity<TruckIdResponseDto> getTruckIdByPlate(@RequestBody TruckPlateRequestDto truckPlateRequest) {
        String message = "The endpoint for obtaining a truckId by plate is initiated, Object obtained -> " + truckPlateRequest;
        log.info(message);

        TruckIdResponseDto truckIdResponseDto = this.truckInterfaceBusiness.getTruckIdByPlate(truckPlateRequest);
        return ResponseEntity.ok(truckIdResponseDto);
    }

    @PutMapping("/update-truck")
    public ResponseEntity<String> updateTruck(@RequestBody TruckRequestDto truckRequestDto) {
        String message = "The endpoint for update a truckId is initiated, Object obtained -> " + truckRequestDto;
        log.info(message);

        String response = this.truckInterfaceBusiness.updateTruck(truckRequestDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/update-mileage")
    public ResponseEntity<String> updateMileage(@RequestBody TruckMileageRequestDto truckMileageRequestDto) {
        String message = "The endpoint for update a truck mileage is initiated, Object obtained -> " + truckMileageRequestDto;
        log.info(message);

        String response = this.truckInterfaceBusiness.updateMileage(truckMileageRequestDto);
        return ResponseEntity.ok(response);
    }
}
