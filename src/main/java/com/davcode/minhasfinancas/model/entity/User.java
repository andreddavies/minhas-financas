package com.davcode.minhasfinancas.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario", schema = "financas")
@Data
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
