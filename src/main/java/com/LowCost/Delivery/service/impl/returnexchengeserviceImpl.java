package com.LowCost.Delivery.service.impl;

import com.LowCost.Delivery.model.returnexchengeentity;
import com.LowCost.Delivery.repository.returnexchengreop;
import com.LowCost.Delivery.service.returnexchengeservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class returnexchengeserviceImpl implements returnexchengeservice {

    private final returnexchengreop repo;

    @Override
    public returnexchengeentity create(returnexchengeentity request) {
        request.setCreatedAt(LocalDateTime.now());
        return repo.save(request);
    }
}
