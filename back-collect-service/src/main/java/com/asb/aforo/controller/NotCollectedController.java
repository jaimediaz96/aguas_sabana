package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.NotCollectedInterfaceBusiness;
import com.asb.aforo.dto.response.NotCollectedResponseDTO;
import com.asb.aforo.model.GgpNotCollected;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/back-capacity-service/collected")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class NotCollectedController {

    private final NotCollectedInterfaceBusiness notcollectedbusiness;
    @PostMapping("/insert")
    public ResponseEntity<GgpNotCollected> insertNotCollected(@RequestBody GgpNotCollected ggpNotCollected){
        return new ResponseEntity<>(notcollectedbusiness.insertNotcollectedTable(ggpNotCollected), HttpStatus.OK);
    }

    @GetMapping("/getNotCollected")
    public ResponseEntity<List<NotCollectedResponseDTO>>getNotCollected(){
        return new ResponseEntity<>(notcollectedbusiness.getNotCollected(),HttpStatus.OK);
    }
}
