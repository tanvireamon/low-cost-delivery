package com.LowCost.Delivery.service;



import org.springframework.stereotype.Service;

import com.LowCost.Delivery.model.InstantDelivery;
import com.LowCost.Delivery.repository.InstantDeliveryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstantDeliveryService {

    private final InstantDeliveryRepository repository;

    public InstantDelivery save(InstantDelivery delivery) {
        return repository.save(delivery);
    }
}

