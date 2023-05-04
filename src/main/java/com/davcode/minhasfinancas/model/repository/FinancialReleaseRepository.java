package com.davcode.minhasfinancas.model.repository;

import com.davcode.minhasfinancas.model.entity.FinancialReleases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialReleaseRepository extends JpaRepository<FinancialReleases, Long> {
}
