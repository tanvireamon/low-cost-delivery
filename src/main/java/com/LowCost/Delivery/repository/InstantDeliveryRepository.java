package com.LowCost.Delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.LowCost.Delivery.model.InstantDelivery;


public interface InstantDeliveryRepository
        extends JpaRepository<InstantDelivery, Long> {
}

