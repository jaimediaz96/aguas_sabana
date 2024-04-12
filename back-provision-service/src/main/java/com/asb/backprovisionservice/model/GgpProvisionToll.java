package com.asb.backprovisionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ggp_provision_toll")
public class GgpProvisionToll {
    @Column(name = "provision_id")
    private Long provisionId;

    @Column(name = "toll_id")
    private Long tollId;

    @Id
    @SequenceGenerator(name = "SEQ-GGP-PROVISION-TOLL", sequenceName = "SEQ_GGP_PROVISION_TOLL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-GGP-PROVISION-TOLL")
    @Column(name = "provision_toll_id")
    private Long provisionTollId;
}
