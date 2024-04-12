package com.asb.backprovisionservice.controller;

import com.asb.backprovisionservice.business.interfaces.ProvisionTypeInterfaceBusiness;
import com.asb.backprovisionservice.model.GgpProvisionType;
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
public class ProvisionTypeController {
    private final ProvisionTypeInterfaceBusiness provisionTypeInterfaceBusiness;

    @GetMapping("/get-all")
    public ResponseEntity<List<GgpProvisionType>> getAllProvisionTypes() {
        log.info("The endpoint for obtaining a list of provision types is initiated");

        List<GgpProvisionType> provisionTypes = this.provisionTypeInterfaceBusiness.getAllProvisionTypes();
        return ResponseEntity.ok(provisionTypes);
    }
}
