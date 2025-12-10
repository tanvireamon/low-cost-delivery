package com.LowCost.Delivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LowCost.Delivery.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // User findByEmail(String email);
     Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
