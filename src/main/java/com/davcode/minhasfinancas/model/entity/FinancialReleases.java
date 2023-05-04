package com.davcode.minhasfinancas.model.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lancamentos", schema = "financas")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public FinancialReleaseType getFinancialReleaseType() {
        return financialReleaseType;
    }

    public void setFinancialReleaseType(FinancialReleaseType financialReleaseType) {
        this.financialReleaseType = financialReleaseType;
    }

    public FinancialReleaseStatus getFinancialReleaseStatus() {
        return financialReleaseStatus;
    }

    public void setFinancialReleaseStatus(FinancialReleaseStatus financialReleaseStatus) {
        this.financialReleaseStatus = financialReleaseStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialReleases that = (FinancialReleases) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(month, that.month) && Objects.equals(year, that.year) && Objects.equals(user, that.user) && Objects.equals(value, that.value) && Objects.equals(created_at, that.created_at) && financialReleaseType == that.financialReleaseType && financialReleaseStatus == that.financialReleaseStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, month, year, user, value, created_at, financialReleaseType, financialReleaseStatus);
    }

    @Override
    public String toString() {
        return "FinancialReleases{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", user=" + user +
                ", value=" + value +
                ", created_at=" + created_at +
                ", financialReleaseType=" + financialReleaseType +
                ", financialReleaseStatus=" + financialReleaseStatus +
                '}';
    }
}
