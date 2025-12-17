package com.LowCost.Delivery.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InstantDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Sender
    private String senderName;
    private String senderPhone;

    @Column(length = 500)
    private String pickupAddress;

    @Column(length = 300)
    private String senderInstructions;

    // Receiver
    private String receiverName;
    private String receiverPhone;

    @Column(length = 500)
    private String deliveryAddress;

    @Column(length = 300)
    private String receiverLandmark;

    // Parcel
    private String parcelType;
    private String parcelWeight;
    private String deliveryTime;

    private String parcelImagePath;

    private Double deliveryCharge;
}
