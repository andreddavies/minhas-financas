package com.davcode.minhasfinancas.model.entity;


import com.davcode.minhasfinancas.model.enums.FinancialReleaseStatus;
import com.davcode.minhasfinancas.model.enums.FinancialReleaseType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamentos", schema = "financas")
@Data
//@Builder
public class FinancialReleases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

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

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private FinancialReleaseType financialReleaseType;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private FinancialReleaseStatus financialReleaseStatus;
}
