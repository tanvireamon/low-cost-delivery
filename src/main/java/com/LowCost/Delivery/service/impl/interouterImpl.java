package com.LowCost.Delivery.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.LowCost.Delivery.model.interoutercityentity;
import com.LowCost.Delivery.repository.interouterrepo;
import com.LowCost.Delivery.service.interouterservice;
@Service
public class interouterImpl implements interouterservice {
    
    private final interouterrepo repository;

    public interouterImpl(interouterrepo repository) {
        this.repository = repository;
    }

    public interoutercityentity create(interoutercityentity request) {

        // Server-side expected date calculation (trustworthy)
        LocalDate today = LocalDate.now();
        if ("Express".equalsIgnoreCase(request.getDeliveryType())) {
            request.setExpectedDate(today.plusDays(1));
        } else {
            request.setExpectedDate(today.plusDays(3));
        }

        request.setCreatedAt(LocalDateTime.now());
        // COD Amount logic (optional strict)
        if ("No".equalsIgnoreCase(request.getCodOption())) {
            request.setCodAmount(null);
        }

        return repository.save(request);
    }
}
