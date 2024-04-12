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
@Table(name="GGP_RECIPIENT_TYPE")
public class GgpRecipientType {

    @Id
    @Column(name = "recipient_type_id")
    private Long recipientTypeId;

    @Column(name = "name")
    private String name;

    @Column(name = "recipient_value")
    private Double recipientValue;

    @Column(name = "aforo_type_id")
    private Long aforoTypeId;


}
