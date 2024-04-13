package com.asb.backtruckservice.business.impl;

import com.asb.backtruckservice.business.intefaces.TruckTypeInterfaceBusiness;
import com.asb.backtruckservice.exception.GenericException;
import com.asb.backtruckservice.model.GgpTruckType;
import com.asb.backtruckservice.repository.TruckTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TruckTypeService implements TruckTypeInterfaceBusiness {
    private final TruckTypeRepository truckTypeRepository;

    @Override
    public List<GgpTruckType> getAllTruckTypes() {
        List<GgpTruckType> types = (List<GgpTruckType>) this.truckTypeRepository.findAll();

        if (types.isEmpty()) {
            log.error("No types found in the database");
            throw new GenericException("No types found in the database", HttpStatus.NO_CONTENT);
        }

        return types;
    }
}
