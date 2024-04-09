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
@Table(name="GGP_PHOTO")
public class GgpPhotos {

    @Id
    @Column(name = "photo_id")
    Long id;
    @Column(name = "path")
    Long path;
    @Column(name = "external_id")
    String externalId;
    @Column(name = "source_type")
    String sourceType;

}
