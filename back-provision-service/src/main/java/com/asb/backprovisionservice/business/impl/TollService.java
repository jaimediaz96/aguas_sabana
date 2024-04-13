package com.asb.backprovisionservice.business.impl;

import com.asb.backprovisionservice.business.interfaces.TollInterfaceBusiness;
import com.asb.backprovisionservice.dto.request.TollRequestDto;
import com.asb.backprovisionservice.dto.response.TollResponseDto;
import com.asb.backprovisionservice.exception.GenericException;
import com.asb.backprovisionservice.model.GgpToll;
import com.asb.backprovisionservice.repository.TollRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class TollService implements TollInterfaceBusiness {
    private final TollRepository tollRepository;

    @Override
    @Transactional
    public TollResponseDto createTolls(TollRequestDto tollRequestDto) {
        TollResponseDto tollResponseDto = new TollResponseDto();

        tollResponseDto.setTollId(new ArrayList<>());

        try {
            tollRequestDto.getNames().forEach(tollName -> {
                GgpToll toll = new GgpToll();

                toll.setName(requireNonNull(tollName, "name"));

                toll = this.tollRepository.save(toll);

                tollResponseDto.getTollId().add(toll.getTollId());

                String messages = "The toll -> { " + toll + " } was save in the entity GgpToll";
                log.info(messages);
            });
        } catch (NullPointerException e) {
            log.error("missing variable: {}", e.getMessage());
            throw new GenericException("missing variable: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error("Error at insert a toll");
            log.error("Causa of error at insert a toll -> {}", e.getCause().toString());
            log.error("Messages of error at insert a toll -> {}", e.getMessage());
            throw new GenericException("It cant insert the toll", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return tollResponseDto;
    }

    @Override
    public List<GgpToll> getAllTolls() {
        List<GgpToll> tolls = (List<GgpToll>) this.tollRepository.findAll();

        if (tolls.isEmpty()) {
            log.error("No tolls found in the database {}", tolls);
            throw new GenericException("No tolls found in the database", HttpStatus.NOT_FOUND);
        }

        return tolls;
    }
}
