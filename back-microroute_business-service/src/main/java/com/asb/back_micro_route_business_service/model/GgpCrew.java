package com.asb.back_micro_route_business_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ggp_crew")
public class GgpCrew {

    @Id
    @Column(name = "crew_id")
    private Long  crew_id;

    @Column(name = "name")
    private String name;


}
