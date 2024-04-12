package com.asb.aforo.dto.request;

import com.asb.aforo.model.GgpRecipient;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AforoRequestDTO {

    private Double totalAforo;
    private Boolean isCollected;
    private String sign;
    private LocalDateTime date;
    private Double latitude;
    private Double longitude;
    private Long microRouteId;
    private Long clientId;
    private Long tempClientId;
    private Long notCollectedId;
    private Long typeId;
    private List<GgpRecipient> recipients;
}
