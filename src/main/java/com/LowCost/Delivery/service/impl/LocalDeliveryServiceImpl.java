package com.LowCost.Delivery.service.impl;

import com.LowCost.Delivery.model.InstantDelivery;
import com.LowCost.Delivery.model.LocalDeliveryEntity;
import com.LowCost.Delivery.repository.InstantDeliveryRepository;
import com.LowCost.Delivery.repository.LocalDeliveryRepository;
import com.LowCost.Delivery.service.LocalDeliveryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LocalDeliveryServiceImpl implements LocalDeliveryService {

    private final LocalDeliveryRepository repository;
    private final InstantDeliveryRepository instantDeliveryRepository;

    @Override
    @Transactional
    public LocalDeliveryEntity create(LocalDeliveryEntity request) {
        // request.setCreatedAt(LocalDateTime.now());
        // return repository.save(request);
        InstantDelivery order = InstantDelivery.builder().build();
        order = instantDeliveryRepository.save(order);

        // 2) local table এ FK set
        request.setOrder(order);
        request.setCreatedAt(LocalDateTime.now());  
        return repository.save(request);
    }
}
