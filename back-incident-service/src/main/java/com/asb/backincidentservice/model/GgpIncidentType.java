package com.asb.backincidentservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ggp_incident_type")
public class GgpIncidentType {
    @Id
    @Column(name = "incident_type_id")
    private Long incidentTypeId;

    @Column(name = "name")
    private String name;
}
