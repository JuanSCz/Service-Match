package com.serviceMatch.serviceMatch.entities;

import com.serviceMatch.serviceMatch.enums.RolEnum;
import java.io.Serializable;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "app_user")
@Data
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RolEnum rol;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate = new Date();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "whats_app", nullable = true)
    private Long whatsApp;
}
