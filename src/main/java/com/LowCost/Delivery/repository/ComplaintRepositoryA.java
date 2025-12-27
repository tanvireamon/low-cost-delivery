package com.LowCost.Delivery.repository;


import com.LowCost.Delivery.model.ComplaintA;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepositoryA extends JpaRepository<ComplaintA, String> {
    List<ComplaintA> findAllByOrderByCreatedAtDesc();
}
