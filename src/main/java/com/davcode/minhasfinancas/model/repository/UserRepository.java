package com.davcode.minhasfinancas.model.repository;

import com.davcode.minhasfinancas.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
