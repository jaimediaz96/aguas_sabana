package com.asb.aforo.dto;

import lombok.Data;

@Data
public class RecipientsDTO {

    private  Long recipientId;
    private  Integer quantity;
    private  Double total;
    private  Long aforoId;
    private  Long recipientTypeId;
    private  Long fillPercentageId;

}
