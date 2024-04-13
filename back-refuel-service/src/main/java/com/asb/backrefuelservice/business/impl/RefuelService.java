package com.asb.backrefuelservice.business.impl;

import com.asb.backrefuelservice.business.interfaces.RefuelInterfaceBusiness;
import com.asb.backrefuelservice.dto.request.RefuelRequestDto;
import com.asb.backrefuelservice.dto.response.RefuelResponseDto;
import com.asb.backrefuelservice.exception.GenericException;
import com.asb.backrefuelservice.model.GgpRefuel;
import com.asb.backrefuelservice.repository.RefuelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class RefuelService implements RefuelInterfaceBusiness {
    private final RefuelRepository refuelRepository;

    @Override
    @Transactional
    public RefuelResponseDto createRefuel(RefuelRequestDto refuelRequestDto) {
        RefuelResponseDto refuelResponseDto = new RefuelResponseDto();

        GgpRefuel refuel = new GgpRefuel();

        try {
            refuel.setPlace(requireNonNull(refuelRequestDto.getPlace(), "place"));
            refuel.setQuantity(requireNonNull(refuelRequestDto.getQuantity(), "quantity"));
            refuel.setCost(requireNonNull(refuelRequestDto.getCost(), "cost"));
            refuel.setRefuelDate(requireNonNull(refuelRequestDto.getRefuelDate(), "refuelDate"));
            refuel.setRefuelTime(requireNonNull(refuelRequestDto.getRefuelTime(), "refuelTime"));
            refuel.setMicroRouteId(requireNonNull(refuelRequestDto.getMicroRouteId(), "microRouteId"));

            refuel = this.refuelRepository.save(refuel);

            String messages = "The refuel -> { " + refuel + " } was save in the entity GgpRefuel";
            log.info(messages);
        } catch (NullPointerException e) {
            log.error("missing variable: {}", e.getMessage());
            throw new GenericException("missing variable: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error at create a refuel");
            log.error("Causa of error at create a refuel -> {}", e.getCause().toString());
            log.error("Messages of error at create a refuel -> {}", e.getMessage());
            throw new GenericException("It cant create a refuel", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        refuelResponseDto.setRefuelId(refuel.getRefuelId());

        return refuelResponseDto;
    }
}
