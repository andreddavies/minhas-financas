package com.davcode.minhasfinancas.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Builder;

@Entity
@Table(name = "usuario", schema = "financas")
@Data
@Builder
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
