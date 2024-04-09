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
@Table(name="ggp_fill_percentage")
public class GgpFillPercentage {

    @Id
    @Column(name = "fill_percentage_id")
    private Long fill_percentage_id;
    @Column(name = "percent")
    private Float percent;
}
