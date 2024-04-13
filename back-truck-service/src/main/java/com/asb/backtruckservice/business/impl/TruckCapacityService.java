package com.asb.backtruckservice.business.impl;

import com.asb.backtruckservice.business.intefaces.TruckCapacityInterfaceBusiness;
import com.asb.backtruckservice.exception.GenericException;
import com.asb.backtruckservice.model.GgpTruckCapacity;
import com.asb.backtruckservice.repository.TruckCapacityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TruckCapacityService implements TruckCapacityInterfaceBusiness {
    private final TruckCapacityRepository truckCapacityRepository;

    @Override
    public List<GgpTruckCapacity> getAllTruckCapacity() {
        List<GgpTruckCapacity> capacities = (List<GgpTruckCapacity>) this.truckCapacityRepository.findAll();

        if (capacities.isEmpty()) {
            log.error("No capacities found in the database");
            throw new GenericException("No capacities found in the database", HttpStatus.NO_CONTENT);
        }

        return capacities;
    }
}
