package com.LowCost.Delivery.service;

import com.LowCost.Delivery.model.ParcelTrackingEntity;

import java.util.Optional;

public interface ParcelTrackingService {
    Optional<ParcelTrackingEntity> findByTrackingId(String trackingId);
}
