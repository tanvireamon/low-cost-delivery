package com.LowCost.Delivery.service.impl;

import com.LowCost.Delivery.model.ParcelTrackingEntity;
import com.LowCost.Delivery.repository.ParcelTrackingRepository;
import com.LowCost.Delivery.service.ParcelTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParcelTrackingServiceImpl implements ParcelTrackingService {

    private final ParcelTrackingRepository repo;

    @Override
    public Optional<ParcelTrackingEntity> findByTrackingId(String trackingId) {
        if (trackingId == null) return Optional.empty();
        return repo.findByTrackingId(trackingId.trim());
    }
}
