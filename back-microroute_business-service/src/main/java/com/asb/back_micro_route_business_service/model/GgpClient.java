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
@Table(name="ggp_client")

public class GgpClient {

    @Id
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "frequency_id")
    private Long frequencyId;

    @Column(name = "aforo_type_id")
    private Long aforoTypeId;


}
