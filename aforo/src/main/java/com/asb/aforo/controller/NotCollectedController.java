package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.NotCollectedInterfaceBusiness;
import com.asb.aforo.model.GgpNotCollected;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collected")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NotCollectedController {

    private final NotCollectedInterfaceBusiness business;
    @PostMapping("/insert")
    public ResponseEntity<GgpNotCollected> insertNotCollected(@RequestBody GgpNotCollected ggpNotCollected){
        return new ResponseEntity<>(business.insertNotcollectedTable(ggpNotCollected), HttpStatus.OK);
    }
}
