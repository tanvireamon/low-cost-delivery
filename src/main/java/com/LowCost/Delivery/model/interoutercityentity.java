package com.LowCost.Delivery.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class interoutercityentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Foreign Key column: order_id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
        name = "order_id",
        referencedColumnName = "order_id",
        nullable = false,
        unique = true
    )
    private InstantDelivery order;

    // Sender
    @Column(nullable = false)
    private String senderName;

    @Column(nullable = false)
    private String senderPhone;

    @Column(nullable = false)
    private String senderCity;

    @Column(nullable = false, length = 500)
    private String pickupAddress;

    // Receiver
    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String receiverPhone;

    @Column(nullable = false)
    private String receiverCity;

    @Column(nullable = false, length = 500)
    private String deliveryAddress;

    // Parcel
    @Column(nullable = false)
    private String parcelCategory; // Document, Fragile Item, etc.

    @Column(nullable = false)
    private String parcelWeight;   // 1kg,2kg,...

    @Column(nullable = false)
    private String deliveryType;   // Regular/Express

    private LocalDate expectedDate;

    // COD
    @Column(nullable = false)
    private String codOption;      // Yes/No

    private BigDecimal codAmount;

    @Column(nullable = false)
    private String returnOption;   // Yes/No

    private LocalDateTime createdAt;
}
