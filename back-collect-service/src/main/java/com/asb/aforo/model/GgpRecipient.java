package com.asb.aforo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="GGP_RECIPIENT")
public class GgpRecipient {

    @Id
    @SequenceGenerator(name = "SEQ_GGRECIPIENT", sequenceName = "SEQ_GGP_RECIPIENT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GGRECIPIENT")
    @Column(name="recipient_id")
    Long recipientId;
    @Column(name="quantity")
    Integer quantity;
    @Column(name="fill_percentage_id")
    Long fillPercentageId;
    @Column(name="total")
    Double total;
    @Column(name="recipient_type_id")
    Long recipientTypeId;
    @Column(name="aforo_id")
    Long aforoId;



}
