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
@Table(name="ggp_user")
public class GgpUser {
    @Id
    @Column(name = "user_id")
    private Long  userId;

    @Column(name = "name")
    private String  name;

    @Column(name = "rol")
    private String  rol;

    @Column(name = "username")
    private String  userName;

    @Column(name = "password")
    private String  password;

    @Column(name = "email")
    private String  email;

}
