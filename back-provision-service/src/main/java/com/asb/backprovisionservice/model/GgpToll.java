package com.asb.backprovisionservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ggp_toll")
public class GgpToll {
    @Id
    @SequenceGenerator(name = "SEQ-GGP-TOLL", sequenceName = "SEQ_GGP_TOLL", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ-GGP-TOLL")
    @Column(name = "toll_id")
    private Long tollId;

    @Column(name = "name")
    private String name;
}
