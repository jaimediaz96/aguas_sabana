package com.asb.aforo.business;

import com.asb.aforo.business.interfaces.RecipientInterfaceBusiness;
import com.asb.aforo.dto.response.ObjectResponse;
import com.asb.aforo.dto.response.RecipientTypeResponseDTO;
import com.asb.aforo.exception.GenericException;
import com.asb.aforo.model.GgpRecipient;
import com.asb.aforo.model.GgpRecipientType;
import com.asb.aforo.repository.RecipientRepository;
import com.asb.aforo.repository.RecipientTypeRepository;
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
public class RecipientService implements RecipientInterfaceBusiness {

    private final RecipientRepository recipientRepository;
    private final RecipientTypeRepository recipientTypeRepository;
    @Override
    public List<RecipientTypeResponseDTO> getRecipientType() {
        List<GgpRecipientType> recipientTypes = (List<GgpRecipientType>) recipientTypeRepository.findAll();
        return recipientTypes.stream()
                .map(recipient -> new RecipientTypeResponseDTO(recipient.getRecipientTypeId(),recipient.getName(),recipient.getRecipientValue(),recipient.getAforoTypeId()))
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
