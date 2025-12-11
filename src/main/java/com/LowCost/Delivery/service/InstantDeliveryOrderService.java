package com.LowCost.Delivery.service;

import java.util.List;

import com.LowCost.Delivery.model.InstantDeliveryOrder;

public interface InstantDeliveryOrderService {

    InstantDeliveryOrder createOrder(InstantDeliveryOrder order);

    InstantDeliveryOrder getByOrderId(String orderId);
    List<InstantDeliveryOrder> getAllOrders();

}
