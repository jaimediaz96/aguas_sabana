package com.asb.aforo.controller;

import com.asb.aforo.business.interfaces.FillPercentageInterfaceBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fill-percentage")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FillPercentageController {

    private final FillPercentageInterfaceBusiness fillPercentageBusiness;
}
