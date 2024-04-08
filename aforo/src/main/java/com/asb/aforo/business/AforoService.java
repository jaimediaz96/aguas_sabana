package com.asb.aforo.business;

import com.asb.aforo.business.interfaces.AforoInterfaceBusines;
import com.asb.aforo.dto.request.AforoRequestDTO;
import com.asb.aforo.dto.response.AforoResponseDTO;
import com.asb.aforo.dto.response.AforoTypesResponseDTO;
import com.asb.aforo.dto.response.ObjectResponse;
import com.asb.aforo.exception.GenericException;
import com.asb.aforo.model.GgpAforo;
import com.asb.aforo.model.GgpAforoTypes;
import com.asb.aforo.model.GgpRecipient;
import com.asb.aforo.repository.AforoRepository;
import com.asb.aforo.repository.AforoTypesRepository;
import com.asb.aforo.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
public class AforoService implements AforoInterfaceBusines {

    private final AforoRepository aforoRepository;
    private final RecipientRepository recipientRepository;
    private final AforoTypesRepository typesRepository;
    @Override
    @Transactional
    public AforoResponseDTO createAforo(AforoRequestDTO request) {
//TODO: CAMBIAR LA FRMA POR UNA IMAGEN CUANDO MANUEL HAGA EL METODO DE SUBIR IMAGENES
        GgpAforo aforo = new GgpAforo();
        try {
            aforo.setAforoTypeId(request.getTypeId());
            aforo.setTotalAforo(request.getTotalAforo());
            aforo.setIsCollected(request.getIsCollected());
            aforo.setAforoSign(request.getSign());
            aforo.setAforoDate(request.getDate());
            aforo.setLatleitude(request.getLatitude());
            aforo.setLongitude(request.getLongitude());
            aforo.setMicroRouteId(request.getMicroRouteId());
            aforo.setClientId(request.getClientId());
            aforo.setTempClientId(request.getTempClientId());
            aforo.setNotCollectedId(request.getNotCollectedId());
            aforoRepository.save(aforo);

        }catch (Exception e){
            log.error("Error al insertar un aforo");
            log.error("Causa del error-> {}",e.getCause().toString());
            log.error("Mensaje del error-> {}",e.getMessage());
            throw new GenericException("No se ejecuto la insercion", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        log.info("Se guardo el objeto aforo->{}",aforo + " en la entidad GgpAforo");
        saveRecipient(request.getRecipients(),aforo.getAforoId());
        AforoResponseDTO response = new AforoResponseDTO();
        response.setAforoId(aforo.getAforoId());
        return response;
    }

    @Override
    public List<AforoTypesResponseDTO> getAforoType() {
        List <GgpAforoTypes> types = (List<GgpAforoTypes>) typesRepository.findAll();
        return types.stream()
                .map(aforoType -> new AforoTypesResponseDTO(aforoType.getAforoTypeId(),aforoType.getName()))
                .collect(Collectors.toList());
    }


    @Transactional
    public ObjectResponse saveRecipient(List<GgpRecipient> recipients, Long aforoId){
        try {
            for (int i = 0; i < recipients.size(); i++) {
                GgpRecipient recipient = new GgpRecipient();
                recipient.setQuantity(recipients.get(i).getQuantity());
                recipient.setFillPercentageId(recipients.get(i).getFillPercentageId());
                recipient.setTotal(recipients.get(i).getTotal());
                recipient.setRecipientTypeId(recipients.get(i).getRecipientTypeId());
                recipient.setAforoId(aforoId);
                recipientRepository.save(recipient);
            }

            log.info("Se insertaron los recipientes correctamente");
        }catch (Exception e){
            log.error("Error al insertar un recipiente");
            log.error("Causa del error-> {}",e.getCause().toString());
            log.error("Mensaje del error-> {}",e.getMessage());
            throw new GenericException("No se Inserto el reicpiente" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ObjectResponse("Recipiente agregado", 0L);
    }
}
