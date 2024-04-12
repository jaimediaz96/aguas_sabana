package com.asb.aforo.model;

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
@Table(name="GGP_NOT_COLLECTED")
public class GgpNotCollected {
    @Id
    @Column(name = "not_collected_id")
    Long id;
    @Column(name = "code")
    Long code;
    @Column(name = "description")
    String description;
}
