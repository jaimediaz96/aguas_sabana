package com.asb.backtruckservice.business.intefaces;

import com.asb.backtruckservice.dto.request.TruckIdRequestDto;
import com.asb.backtruckservice.dto.request.TruckMileageRequestDto;
import com.asb.backtruckservice.dto.request.TruckPlateRequestDto;
import com.asb.backtruckservice.dto.request.TruckRequestDto;
import com.asb.backtruckservice.dto.response.TruckIdResponseDto;
import com.asb.backtruckservice.dto.response.TruckPlatesResponseDto;
import com.asb.backtruckservice.dto.response.TruckResponseDto;

import java.util.List;

public interface TruckInterfaceBusiness {
    List<TruckPlatesResponseDto> getAllTruckPlates();
    TruckResponseDto getTruckById(TruckIdRequestDto truckIdRequestDto);
    TruckIdResponseDto getTruckIdByPlate(TruckPlateRequestDto truckPlateRequestDto);
    String updateTruck(TruckRequestDto truckRequestDto);
    String updateMileage(TruckMileageRequestDto truckMileageRequestDto);
}
