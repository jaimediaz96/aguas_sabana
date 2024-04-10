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
@Table(name="ggp_aforo_type ")
public class GgpAforoType {

    @Id
    @Column(name = "aforo_type_id")
    private Long aforoTypeId;

    @Column(name = "aforo_type_extern_id")
    private Long aforoTypeExternId;

    @Column(name = "name")
    private String name;

}
