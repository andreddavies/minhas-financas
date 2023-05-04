package com.davcode.minhasfinancas.model.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamentos", schema = "financas")
public class FinancialReleases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "created_at")
    @Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
    private LocalDate created_at;
}
