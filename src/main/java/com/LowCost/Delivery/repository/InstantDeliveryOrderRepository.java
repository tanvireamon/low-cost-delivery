package com.LowCost.Delivery.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.LowCost.Delivery.model.InstantDeliveryOrder;

import java.util.Optional;

public interface InstantDeliveryOrderRepository
        extends JpaRepository<InstantDeliveryOrder, Long> {

    Optional<InstantDeliveryOrder> findByOrderId(String orderId);
}
