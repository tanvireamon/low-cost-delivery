package com.LowCost.Delivery.service;

import java.util.List;

import com.LowCost.Delivery.model.AvailableOrderDto;

public interface EarnOrderService {
    List<AvailableOrderDto> getAvailableOrders();
    void accept(String sourceType, Long sourcePk);
    void reject(String sourceType, Long sourcePk);
}
