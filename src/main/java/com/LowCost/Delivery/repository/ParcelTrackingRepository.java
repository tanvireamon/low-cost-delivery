package com.LowCost.Delivery.repository;

import com.LowCost.Delivery.model.ParcelTrackingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParcelTrackingRepository extends JpaRepository<ParcelTrackingEntity, Long> {
    Optional<ParcelTrackingEntity> findByTrackingId(String trackingId);
}
