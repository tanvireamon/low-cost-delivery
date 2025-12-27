package com.LowCost.Delivery.model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "complaintsshowforadmin")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ComplaintA {

    // আপনার ID C9001 টাইপ হলে String রাখাই best
    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, length = 1000)
    private String message;

    // OPEN / RESOLVED
    @Column(nullable = false)
    private String status;

    @Column(length = 1000)
    private String adminReply;

    private LocalDateTime createdAt;
    private LocalDateTime resolvedAt;
}
