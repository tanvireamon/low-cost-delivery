
package com.LowCost.Delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "local_delivery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalDeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sender
    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String senderPhone;

    @Column(nullable = false, length = 500)
    private String pickupAddress;

    // Receiver
    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String receiverPhone;

    @Column(nullable = false, length = 500)
    private String deliveryAddress;

    // Parcel
    @Column(nullable = false)
    private String parcelType;      // Documents, Food, Clothes etc.

    @Column(nullable = false)
    private String parcelWeight;    // Small, Medium, Large

    @Column(nullable = false)
    private String deliveryTime;    // Fast, Normal

    @Column(length = 500)
    private String instructions;

    private LocalDateTime createdAt;
}
