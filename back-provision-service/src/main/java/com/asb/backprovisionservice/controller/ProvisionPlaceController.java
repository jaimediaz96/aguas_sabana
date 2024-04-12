package com.asb.backprovisionservice.controller;

import com.asb.backprovisionservice.business.interfaces.ProvisionPlaceInterfaceBusiness;
import com.asb.backprovisionservice.model.GgpProvisionPlace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("${application.request.mappings}/place")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProvisionPlaceController {
    private final ProvisionPlaceInterfaceBusiness provisionPlaceInterfaceBusiness;

    @GetMapping("/get-all")
    public ResponseEntity<List<GgpProvisionPlace>> getAllProvisionPlace() {
        log.info("The endpoint for obtaining a list of provision places is initiated");

        List<GgpProvisionPlace> provisionPlaces = this.provisionPlaceInterfaceBusiness.getAllProvisionPlaces();
        return ResponseEntity.ok(provisionPlaces);
    }
}
