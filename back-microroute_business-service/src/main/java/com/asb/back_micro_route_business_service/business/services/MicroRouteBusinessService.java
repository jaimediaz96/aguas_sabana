package com.asb.back_micro_route_business_service.business.services;

import com.asb.back_micro_route_business_service.business.interfaces.MicroRouteInterfaceBusiness;
import com.asb.back_micro_route_business_service.dto.response.ClientResponseDTO;
import com.asb.back_micro_route_business_service.dto.response.GetMicroRouteResponseDTO;
import com.asb.back_micro_route_business_service.exception.GenericException;
import com.asb.back_micro_route_business_service.repository.MicroRouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class MicroRouteBusinessService implements MicroRouteInterfaceBusiness {

    private final MicroRouteRepository microRouteRepository;
    @Override
    public GetMicroRouteResponseDTO getMicroRouteByUserId(Long userId) {
        var microRoutes = microRouteRepository.getMicroRouteData(userId);
        GetMicroRouteResponseDTO response = new GetMicroRouteResponseDTO();
        if(!microRoutes.isEmpty()){
            for(Object[] obj: microRoutes){
                response.setMicroRouteId(obj[0] != null ? Long.parseLong(obj[0].toString()) : null);
                response.setRouteName(obj[1] != null ? obj[1].toString() : null);
                response.setRouteDescription(obj[2] != null ? obj[2].toString() : null);
                response.setName(obj[3] != null ? obj[3].toString() : null);
                response.setPlate(obj[4] != null ? obj[4].toString() : null);
            }
            response.setClients(ListClient(userId));
        }else{
            throw new GenericException("Usuario no encontrado.", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    List<ClientResponseDTO> ListClient(Long userId){
        List<ClientResponseDTO> users = new ArrayList<>();
        var objects = microRouteRepository.getClientData(userId);
        if(!objects.isEmpty()){
            for(Object[] obj: objects){
                var user = new ClientResponseDTO();
                user.setClientId(obj[0] != null ? Long.parseLong(obj[0].toString()) : null);
                user.setCompanyName(obj[1] != null ? obj[1].toString() : null);
                user.setAddress(obj[2] != null ? obj[2].toString() : null);
                user.setAforoId(obj[3] != null ? Long.parseLong(obj[3].toString()) : null);
                user.setAforoName(obj[4] != null ? obj[4].toString() : null);
                users.add(user);
            }
        }else{
            throw new GenericException("ususario no encontrado.", HttpStatus.NOT_FOUND);
        }
        return users;
    }
}
