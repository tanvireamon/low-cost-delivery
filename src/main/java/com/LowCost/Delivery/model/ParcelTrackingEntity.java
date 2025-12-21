package com.LowCost.Delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "parcel_tracking", indexes = {
        @Index(name = "idx_tracking_id", columnList = "trackingId", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParcelTrackingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String trackingId;     // e.g. LCD-20251220-AB12CD

    // Optional - later OTP verification e add hobe
    private String phone;

    @Column(nullable = false)
    private String currentStatus;  // Pickup, Sorting, On the way, Destination, Delivered

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

    private LocalDateTime createdAt;
}
