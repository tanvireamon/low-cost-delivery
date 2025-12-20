package com.LowCost.Delivery.service.impl;

import com.LowCost.Delivery.model.LocalDeliveryEntity;
import com.LowCost.Delivery.repository.LocalDeliveryRepository;
import com.LowCost.Delivery.service.LocalDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocalDeliveryServiceImpl implements LocalDeliveryService {

    private final LocalDeliveryRepository repository;

    @Override
    public LocalDeliveryEntity create(LocalDeliveryEntity request) {
        request.setCreatedAt(LocalDateTime.now());
        return repository.save(request);
    }
}
