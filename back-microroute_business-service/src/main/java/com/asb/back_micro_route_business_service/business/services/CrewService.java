package com.asb.back_micro_route_business_service.business.services;

import com.asb.back_micro_route_business_service.business.interfaces.CrewInterfaceBusiness;
import com.asb.back_micro_route_business_service.dto.response.CrewDTO;
import com.asb.back_micro_route_business_service.exception.GenericException;
import com.asb.back_micro_route_business_service.model.GgpCrew;
import com.asb.back_micro_route_business_service.repository.CrewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class CrewService implements CrewInterfaceBusiness {

    private final CrewRepository crewRepository;

    @Override
    public List<CrewDTO> getCrew() {
        List<GgpCrew> crews = (List<GgpCrew>) crewRepository.findAll();
        if (crews.isEmpty()) {throw new GenericException("No hay acompañantes registrados" , HttpStatus.NO_CONTENT);
        }else {
            return crews.stream().map(crew -> new CrewDTO(crew.getCrew_id(), crew.getName()))
                    .collect(Collectors.toList());
        }
    }
}
