package com.LowCost.Delivery.model;



import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "instant_delivery_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstantDeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Unique public order id (e.g. ORD-20241211-AB12CD34)
    @Column(nullable = false, unique = true, length = 40)
    private String orderId;

    // Sender
    private String senderName;
    private String senderPhone;

    @Column(length = 500)
    private String pickupAddress;

    @Column(length = 500)
    private String senderInstructions;

    // Receiver
    private String receiverName;
    private String receiverPhone;

    @Column(length = 500)
    private String deliveryAddress;

    @Column(length = 500)
    private String receiverLandmark;

    // Parcel
    private String parcelType;
    private String parcelWeight;
    private String deliveryTime;   // could be enum in future
    //private BigDecimal deliveryCharge;

    private BigDecimal deliveryCharge;

    // Image file name stored on disk (uploads folder)
    private String imageFileName;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
