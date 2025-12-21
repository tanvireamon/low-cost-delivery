package com.LowCost.Delivery.model;
//package com.LowCost.Delivery.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvailableOrderDto {

    private String orderId;      // common display id (ex: #1021)
    private String pickup;       // pickup place/city/address
    private String drop;         // drop city/address
    private String parcelType;   // parcel type/category
    private String date;         // display date string
    private Double earning;      // earning amount
    private String sourceType;   // INSTANT / LOCAL / INTER_OUTER
    private Long sourcePk;       // original table primary key (InstantDelivery.id etc)
}
