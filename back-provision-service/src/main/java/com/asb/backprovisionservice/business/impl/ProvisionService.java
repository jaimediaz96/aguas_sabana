package com.asb.backprovisionservice.business.impl;

import com.asb.backprovisionservice.business.interfaces.ProvisionInterfaceBusiness;
import com.asb.backprovisionservice.dto.request.ProvisionRequestDto;
import com.asb.backprovisionservice.dto.response.ProvisionResponseDto;
import com.asb.backprovisionservice.exception.GenericException;
import com.asb.backprovisionservice.model.GgpProvision;
import com.asb.backprovisionservice.model.GgpProvisionToll;
import com.asb.backprovisionservice.repository.ProvisionRepository;
import com.asb.backprovisionservice.repository.ProvisionTollRepository;
import com.asb.backprovisionservice.repository.TollRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class ProvisionService implements ProvisionInterfaceBusiness, ApplicationContextAware {
    private ApplicationContext applicationContext;

    private final ProvisionRepository provisionRepository;
    private final ProvisionTollRepository provisionTollRepository;
    private final TollRepository tollRepository;

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public ProvisionResponseDto createProvision(ProvisionRequestDto provisionRequestDto) {
        ProvisionService proxy = applicationContext.getBean(ProvisionService.class);

        provisionRequestDto.getTollIds().forEach(tollId -> {
            if (tollId == null) throw new GenericException("missing tollId", HttpStatus.BAD_REQUEST);

            boolean isTollExist = tollRepository.existsById(tollId);
            if (!isTollExist) {
                String messages = "This tollId = " + tollId + " doesnt exist";
                throw new GenericException(messages, HttpStatus.BAD_REQUEST);
            }
        });

        Long provisionId = proxy.saveProvision(provisionRequestDto);

        proxy.saveProvisionTolls(provisionId, provisionRequestDto.getTollIds());

        ProvisionResponseDto provisionResponseDto = new ProvisionResponseDto();
        provisionResponseDto.setProvisionId(provisionId);

        return provisionResponseDto;
    }

    @Transactional
    public Long saveProvision(ProvisionRequestDto provisionRequestDto) {
        GgpProvision provision = new GgpProvision();

        try {
            provision.setKmStart(requireNonNull(provisionRequestDto.getKmStart(), "kmStart"));
            provision.setKmFinish(requireNonNull(provisionRequestDto.getKmFinish(), "kmFinish"));
            provision.setProvisionDate(requireNonNull(provisionRequestDto.getProvisionDate(), "provisionDate"));
            provision.setProvisionTimeTrip(requireNonNull(provisionRequestDto.getProvisionTimeTrip(), "provisionTimeTrip"));
            provision.setProvisionTimePlace(requireNonNull(provisionRequestDto.getProvisionTimePlace(), "provisionTimePlace"));
            provision.setWeight(requireNonNull(provisionRequestDto.getWeight(), "weight"));
            provision.setMicroRouteId(requireNonNull(provisionRequestDto.getMicroRouteId(), "microRouteId"));
            provision.setProvisionPlaceId(requireNonNull(provisionRequestDto.getProvisionPlaceId(), "provisionPlaceId"));
            provision.setProvisionTypeId(requireNonNull(provisionRequestDto.getProvisionTypeId(), "provisionTypeId"));

            provision = this.provisionRepository.save(provision);
        } catch (NullPointerException e) {
            log.error("missing variable: {}", e.getMessage());
            throw new GenericException("missing variable: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error at insert a provision");
            log.error("Causa of error at insert a provision -> {}", e.getCause().toString());
            log.error("Messages of error at insert a provision -> {}", e.getMessage());
            throw new GenericException("It cant insert", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String messages = "The object provision -> " + provision + " was save in the entity GgpProvision";
        log.info(messages);

        return provision.getProvisionId();
    }

    @Transactional
    public void saveProvisionTolls(Long provisionId, List<Long> tollsId) {
        try {
            tollsId.forEach (tollId -> {

                GgpProvisionToll provisionToll = new GgpProvisionToll();

                provisionToll.setProvisionId(provisionId);
                provisionToll.setTollId(tollId);

                this.provisionTollRepository.save(provisionToll);
            });
        } catch (Exception e) {
            log.error("Error at insert a provisionToll");
            log.error("Causa of error at insert a provisionToll -> {}", e.getCause().toString());
            log.error("Messages of error at insert a provisionToll -> {}", e.getMessage());
            throw new GenericException("It cant insert the provisionToll", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String messages = "The list tollsId -> " + tollsId + " was save in the entity GgpProvisionToll";
        log.info(messages);
    }
}
