package com.LowCost.Delivery.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.LowCost.Delivery.model.InstantDeliveryOrder;
import com.LowCost.Delivery.repository.InstantDeliveryOrderRepository;
import com.LowCost.Delivery.service.InstantDeliveryOrderService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InstantDeliveryOrderServiceImpl implements InstantDeliveryOrderService {

    private final InstantDeliveryOrderRepository repository;

    @Override
    public InstantDeliveryOrder createOrder(InstantDeliveryOrder order) {
        // generate unique order id if not set
        if (order.getOrderId() == null || order.getOrderId().isBlank()) {
            order.setOrderId(generateOrderId());
        }
        return repository.save(order);
    }

    @Override
    public InstantDeliveryOrder getByOrderId(String orderId) {
        return repository.findByOrderId(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
    }

    private String generateOrderId() {
        String datePart = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE); // 20241211
        String randomPart = UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 8)
                .toUpperCase();
        return "ORD-" + datePart + "-" + randomPart;
    }

    @Override
    public List<InstantDeliveryOrder> getAllOrders() {
        return repository.findAll();
    }

}
