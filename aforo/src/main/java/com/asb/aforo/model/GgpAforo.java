package com.asb.aforo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ggp_aforo")
public class GgpAforo {

    @Id
    @SequenceGenerator(name = "SEQ_GGPAFORO", sequenceName = "SEQ_GGP_AFORO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GGPAFORO")
    @Column(name="aforo_id")
    private Long aforoId;

    @Column(name="aforo_type_id")
    private Long aforoTypeId;

    @Column(name="total_aforo")
    private Double totalAforo;

    @Column(name="is_collected")
    private Boolean isCollected ;

    @Column(name="aforo_sign")
    private String aforoSign;

    @Column(name="aforo_date")
    private LocalDateTime aforoDate;

    @Column(name="latleitude")
    private Double latleitude;

    @Column(name="longitude")
    private Double longitude ;

    @Column(name="micro_route_id")
    private Long microRouteId;

    @Column(name="client_id")
    private Long clientId;

    @Column(name="temp_client_id")
    private Long tempClientId;

    @Column(name="not_collected_id")
    private Long notCollectedId;

}
