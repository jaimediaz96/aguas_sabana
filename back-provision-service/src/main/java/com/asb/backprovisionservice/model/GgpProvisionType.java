package com.asb.backprovisionservice.model;

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
@Table(name = "ggp_provision_type")
public class GgpProvisionType {
    @Id
    @Column(name = "provision_type_id")
    private Long provisionTypeId;

    @Column(name = "name")
    private String name;
}
