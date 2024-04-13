package com.asb.backtruckservice.business.impl;

import com.asb.backtruckservice.business.intefaces.TruckInterfaceBusiness;
import com.asb.backtruckservice.dto.request.TruckIdRequestDto;
import com.asb.backtruckservice.dto.request.TruckMileageRequestDto;
import com.asb.backtruckservice.dto.request.TruckPlateRequestDto;
import com.asb.backtruckservice.dto.request.TruckRequestDto;
import com.asb.backtruckservice.dto.response.TruckIdResponseDto;
import com.asb.backtruckservice.dto.response.TruckPlatesResponseDto;
import com.asb.backtruckservice.dto.response.TruckResponseDto;
import com.asb.backtruckservice.exception.GenericException;
import com.asb.backtruckservice.model.GgpTruck;
import com.asb.backtruckservice.repository.TruckRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TruckService implements TruckInterfaceBusiness {
    public static final String TRUCK_NOT_FOUND = "No truck found";
    public static final String TRUCK_ID = "truckId";
    public static final String MISSING_VARIABLE = "Missing variable: ";
    private final TruckRepository truckRepository;

    @Override
    public List<TruckPlatesResponseDto> getAllTruckPlates() {
        var plates = this.truckRepository.findAllPates();

        if (plates == null || plates.isEmpty()) {
            log.error("No plates found in the database");
            throw new GenericException("No plates found in the database", HttpStatus.NO_CONTENT);
        }

        List<TruckPlatesResponseDto> platesResponse = new ArrayList<>();
        for (Object[] obj : plates) {
            TruckPlatesResponseDto truckPlatesResponse = new TruckPlatesResponseDto();

            truckPlatesResponse.setTruckId(parseLong(obj[0]));
            truckPlatesResponse.setPlate(parseString(obj[1]));

            platesResponse.add(truckPlatesResponse);
        }

        return platesResponse;
    }

    @Override
    public TruckResponseDto getTruckById(TruckIdRequestDto truckIdRequestDto) {

        try {
            requireNonNull(truckIdRequestDto.getTruckId(), TRUCK_ID);
        } catch (NullPointerException e) {
            log.error("getTruckById:" + MISSING_VARIABLE + "{}", e.getMessage());
            throw new GenericException(MISSING_VARIABLE + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        var truck = this.truckRepository.findTruckById(truckIdRequestDto.getTruckId());

        if (truck == null) {
            log.error(TRUCK_NOT_FOUND);
            throw new GenericException(TRUCK_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        TruckResponseDto truckResponse = new TruckResponseDto();

        for (Object[] obj: truck) {
            truckResponse.setTruckId(parseLong(obj[0]));
            truckResponse.setPlate(parseString(obj[1]));
            truckResponse.setPapers(obj[2] != null ? Boolean.parseBoolean(obj[2].toString()) : null);
            truckResponse.setMaintenance(parseLocalDateTime(obj[3]));
            truckResponse.setMileage(parseLong(obj[4]));
            truckResponse.setTire(parseString(obj[5]));
            truckResponse.setPressure(parseString(obj[6]));
            truckResponse.setFuel(parseString(obj[7]));
            truckResponse.setLight(parseString(obj[8]));
            truckResponse.setHonk(parseString(obj[9]));
            truckResponse.setBrake(parseString(obj[10]));
            truckResponse.setOil(parseString(obj[11]));
            truckResponse.setObservation(parseString(obj[12]));
            truckResponse.setType(parseString(obj[13]));
            truckResponse.setCapacity(obj[14] != null ? Double.parseDouble(obj[14].toString()) : null);
        }

        return truckResponse;
    }

    @Override
    public TruckIdResponseDto getTruckIdByPlate(TruckPlateRequestDto truckPlateRequestDto) {
        String plate = truckPlateRequestDto.getPlate();

        try {
            requireNonNull(plate, "plate");
        } catch (NullPointerException e) {
            log.error("getTruckIdByPlate:" + MISSING_VARIABLE + "{}", e.getMessage());
            throw new GenericException(MISSING_VARIABLE + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        TruckIdResponseDto truckIdResponseDto = new TruckIdResponseDto();

        GgpTruck truck = this.truckRepository.findFirstTruckIdByPlateContaining(plate).orElse(null);

        if (truck == null) {
            log.error("getTruckIdByPlate: " + TRUCK_NOT_FOUND);
            throw new GenericException(TRUCK_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        truckIdResponseDto.setTruckId(truck.getTruckId());

        return truckIdResponseDto;
    }

    @Override
    @Transactional
    public String updateTruck(TruckRequestDto truckRequestDto) {
        try {
            requireNonNull(truckRequestDto.getTruckId(), TRUCK_ID);
        } catch (NullPointerException e) {
            log.error("updateTruck truckId" + MISSING_VARIABLE+ "{}", e.getMessage());
            throw new GenericException(MISSING_VARIABLE + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        GgpTruck truck = this.truckRepository.findById(truckRequestDto.getTruckId()).orElse(null);

        if (truck == null) {
            log.error("updateTruck: " + TRUCK_NOT_FOUND);
            throw new GenericException(TRUCK_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        try {
            truck.setPlate(requireNonNull(truckRequestDto.getPlate(), "plate"));
            truck.setPapers(requireNonNull(truckRequestDto.getPapers(), "papers"));
            truck.setMileage(requireNonNull(truckRequestDto.getMileage(), "mileage"));
            truck.setTire(requireNonNull(truckRequestDto.getTire(), "tire"));
            truck.setPressure(requireNonNull(truckRequestDto.getPressure(), "pressure"));
            truck.setFuel(requireNonNull(truckRequestDto.getFuel(), "fuel"));
            truck.setLight(requireNonNull(truckRequestDto.getLight(), "light"));
            truck.setHonk(requireNonNull(truckRequestDto.getHonk(), "honk"));
            truck.setBrake(requireNonNull(truckRequestDto.getBrake(), "brake"));
            truck.setOil(requireNonNull(truckRequestDto.getOil(), "oil"));
            truck.setObservation(requireNonNull(truckRequestDto.getObservation(), "observation"));

            this.truckRepository.save(truck);

            log.info("Truck updated");
        } catch (NullPointerException e) {
            log.error("updateTruck" + MISSING_VARIABLE + "{}", e.getMessage());
            throw new GenericException(MISSING_VARIABLE + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error at update a truck");
            log.error("Causa of error at update a truck -> {}", e.getCause().toString());
            log.error("Messages of error at update a truck -> {}", e.getMessage());
            throw new GenericException("It cant update the truck", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "Truck Updated Successfully";
    }

    @Override
    public String updateMileage(TruckMileageRequestDto truckMileageRequestDto) {
        Long truckId = truckMileageRequestDto.getTruckId();
        Long mileage = truckMileageRequestDto.getMileage();

        try {
            requireNonNull(truckId, TRUCK_ID);
            requireNonNull(mileage, "mileage");
        } catch (NullPointerException e) {
            log.error("updateMileage truckId" + MISSING_VARIABLE + "{}", e.getMessage());
            log.error("truckId: {}", truckId);
            log.error("mileage: {}", mileage);
            throw new GenericException(MISSING_VARIABLE + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (!this.truckRepository.existsById(truckId)) {
            log.info("Truck mileage updated");
            throw new GenericException(TRUCK_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        try {
            this.truckRepository.updateMileageByTruckId(truckId, mileage);
        } catch (Exception e) {
            log.error("Error at update a truck mileage");
            log.error("Causa of error at update a truck mileage -> {}", e.getCause().toString());
            log.error("Messages of error at update a truck mileage -> {}", e.getMessage());
            throw new GenericException("It cant update a truck mileage", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "Mileage Updated Successfully";
    }

    public Long parseLong(Object obj) {
        return obj != null ? Long.parseLong(obj.toString()) : null;
    }

    public String parseString(Object obj) {
        return obj != null ? obj.toString() : null;
    }

    public LocalDateTime parseLocalDateTime(Object obj) {
        String date  = parseString(obj);

        if (date == null) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        return LocalDateTime.parse(date, formatter);
    }
}
