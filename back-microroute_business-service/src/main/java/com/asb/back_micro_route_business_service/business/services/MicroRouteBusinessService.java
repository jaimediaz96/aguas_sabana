package com.asb.back_micro_route_business_service.business.services;

import com.asb.back_micro_route_business_service.business.interfaces.MicroRouteInterfaceBusiness;
import com.asb.back_micro_route_business_service.dto.request.MicroRouteRequestDTO;
import com.asb.back_micro_route_business_service.dto.response.ClientResponseDTO;
import com.asb.back_micro_route_business_service.dto.response.DensityDTO;
import com.asb.back_micro_route_business_service.dto.response.GetMicroRouteResponseDTO;
import com.asb.back_micro_route_business_service.dto.response.ObjectResponse;
import com.asb.back_micro_route_business_service.exception.GenericException;
import com.asb.back_micro_route_business_service.model.GgpMicroRoute;
import com.asb.back_micro_route_business_service.repository.MicroRouteRepository;
import com.asb.back_micro_route_business_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class MicroRouteBusinessService implements MicroRouteInterfaceBusiness {

    private final MicroRouteRepository microRouteRepository;
    private final UserRepository userRepository;
    @Override
    public GetMicroRouteResponseDTO getMicroRouteByUserId(Long userId) {
        if (userRepository.findById(userId).isEmpty()) {
            throw new GenericException("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
        var microRoutes = microRouteRepository.getMicroRouteData(userId);
        log.info("microRoutes: {}", microRoutes);
        if (microRoutes == null || microRoutes.isEmpty()) {
            throw new GenericException("No hay micro ruta que mostrar", HttpStatus.NOT_FOUND);
        }
        GetMicroRouteResponseDTO response = new GetMicroRouteResponseDTO();
            for(Object[] obj: microRoutes){
                response.setMicroRouteId(obj[0] != null ? Long.parseLong(obj[0].toString()) : null);
                response.setRouteName(obj[1] != null ? obj[1].toString() : null);
                response.setRouteDescription(obj[2] != null ? obj[2].toString() : null);
                response.setName(obj[3] != null ? obj[3].toString() : null);
                response.setPlate(obj[4] != null ? obj[4].toString() : null);
            }
            response.setClients(ListClient(userId));
        return response;
    }

    @Override
    public DensityDTO getDensity(Long microRouteId) {
        var microRoute = microRouteRepository.findById(microRouteId);
        log.info("micro rote {}", microRoute);
        DensityDTO density = new DensityDTO();
        density.setDensity(Double.parseDouble(microRoute.get().getDensity().toString()));
        return density;
    }

    @Override
    @Transactional
    public ObjectResponse updateMicroRoute(Long microRouteId, MicroRouteRequestDTO request) {
        try {
            GgpMicroRoute newMicroRoute = new GgpMicroRoute();
            Optional<GgpMicroRoute> microRoute = microRouteRepository.findById(microRouteId);
            if (microRoute.isPresent()) {
                newMicroRoute = microRoute.get();
            }
            if (request.getDateFinish() != null) newMicroRoute.setMicroRouteDateFinish(request.getDateFinish());
            if (request.getMilage() != null) newMicroRoute.setMilage(request.getMilage());
            if (request.getMicroRouteAforoTime() != null) newMicroRoute.setMicroRouteAforoTime(request.getMicroRouteAforoTime());
            if (request.getMicroRouteTripHomeTime() != null) newMicroRoute.setMicroRouteTripHomeTime(request.getMicroRouteTripHomeTime());
            if (request.getTotalAforo() != null) newMicroRoute.setTotalAforo(request.getTotalAforo());
            if (request.getDensity() != null) newMicroRoute.setDensity(request.getDensity());
            if (request.getDescriptionAbandon() != null) newMicroRoute.setDescriptionAbandon(request.getDescriptionAbandon());
            microRouteRepository.save(newMicroRoute);

            log.info("Se modifico la entidad -> {}" ,newMicroRoute);
        }catch (Exception e){
            log.error("Error al actualizar la micro ruta");
            log.error("Causa del error-> {}",e.getCause().toString());
            log.error("Mensaje del error-> {}",e.getMessage());
            throw new GenericException("No se pudo actualizar la micro ruta" , HttpStatus.BAD_REQUEST);
        }
        return new ObjectResponse("Micro ruta Actualizada" , 0L);
    }

    List<ClientResponseDTO> ListClient(Long userId){
        List<ClientResponseDTO> users = new ArrayList<>();
        var objects = microRouteRepository.getClientData(userId);
        if (objects == null || objects.isEmpty()) {
            throw new GenericException("No hay lista de clientes que mostrar", HttpStatus.NOT_FOUND);
        }
            for(Object[] obj: objects){
                var user = new ClientResponseDTO();
                user.setClientId(obj[0] != null ? Long.parseLong(obj[0].toString()) : null);
                user.setCompanyName(obj[1] != null ? obj[1].toString() : null);
                user.setAddress(obj[2] != null ? obj[2].toString() : null);
                user.setAforoId(obj[3] != null ? Long.parseLong(obj[3].toString()) : null);
                user.setAforoName(obj[4] != null ? obj[4].toString() : null);
                users.add(user);
            }
        return users;
    }
}
