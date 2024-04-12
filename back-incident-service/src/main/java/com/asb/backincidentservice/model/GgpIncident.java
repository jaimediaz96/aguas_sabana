package com.asb.backincidentservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ggp_incident")
public class GgpIncident {
    @Id
    @SequenceGenerator(name = "SEQ-GGP-INCIDENT", sequenceName = "seq_ggp_incident", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-GGP-INCIDENT")
    @Column(name = "incident_id")
    private Long incidentId;

    @Column(name = "description")
    private String description;

    @Column(name = "incident_date")
    private LocalDateTime incidentDate;

    @Column(name = "incident_time")
    private Long incidentTime;

    @Column(name = "incident_type_id")
    private Long incidentTypeId;

    @Column(name = "micro_route_id")
    private Long microRouteId;
}
