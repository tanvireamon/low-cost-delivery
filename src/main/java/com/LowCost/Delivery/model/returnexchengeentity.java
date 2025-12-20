package com.LowCost.Delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "return_exchange")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class returnexchengeentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer Information
    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String customerPhone;

    @Column(nullable = false)
    private String orderNumber;

    private String customerEmail;

    // Pickup Information
    @Column(nullable = false, length = 500)
    private String pickupAddress;

    @Column(nullable = false)
    private String pickupCity;

    @Column(nullable = false)
    private LocalDate pickupDate;

    // Product Information
    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private String reasonReturn;

    @Column(nullable = false)
    private String itemCondition;

    @Column(nullable = false)
    private String exchangeOrRefund;

    private LocalDateTime createdAt;
}

