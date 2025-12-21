package com.LowCost.Delivery.service.impl;


import com.LowCost.Delivery.model.AvailableOrderDto;
import com.LowCost.Delivery.model.InstantDelivery;
import com.LowCost.Delivery.model.LocalDeliveryEntity;
import com.LowCost.Delivery.model.interoutercityentity;
import com.LowCost.Delivery.repository.InstantDeliveryRepository;
import com.LowCost.Delivery.repository.LocalDeliveryRepository;
import com.LowCost.Delivery.repository.interouterrepo;
import com.LowCost.Delivery.service.EarnOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EarnOrderServiceImpl implements EarnOrderService {

    private final InstantDeliveryRepository instantRepo;
    private final LocalDeliveryRepository localRepo;
    private final interouterrepo interRepo;

    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public List<AvailableOrderDto> getAvailableOrders() {

        List<AvailableOrderDto> list = new ArrayList<>();

        // ✅ 1) Instant Delivery
        for (InstantDelivery d : instantRepo.findAll()) {
            list.add(AvailableOrderDto.builder()
                    .orderId("#INST-" + System.identityHashCode(d))                 // common display (fallback)
                    .pickup(shortText(d.getPickupAddress()))
                    .drop(shortText(d.getDeliveryAddress()))
                    .parcelType(nvl(d.getParcelType(), "N/A"))
                    .date("N/A") // আপনার entity তে date নাই; থাকলে বসাবেন
                    .earning(d.getDeliveryCharge() != null ? d.getDeliveryCharge() : 0.0)
                    .sourceType("INSTANT")
                    .sourcePk(null)
                    .build());
        }

        // ✅ 2) Local Delivery
        for (LocalDeliveryEntity d : localRepo.findAll()) {
            list.add(AvailableOrderDto.builder()
                    .orderId("#" + d.getId())
                    .pickup(shortText(d.getPickupAddress()))
                    .drop(shortText(d.getDeliveryAddress()))
                    .parcelType(nvl(d.getParcelType(), "N/A"))
                    .date(d.getCreatedAt() != null ? d.getCreatedAt().toLocalDate().format(DF) : "N/A")
                    .earning(0.0) // local charge field নাই—চাইলে calculate করে দিন
                    .sourceType("LOCAL")
                    .sourcePk(d.getId())
                    .build());
        }

        // ✅ 3) Inter / Outer
        for (interoutercityentity d : interRepo.findAll()) {
            list.add(AvailableOrderDto.builder()
                    .orderId("#" + d.getId())
                    .pickup(nvl(d.getSenderCity(), "N/A"))
                    .drop(nvl(d.getReceiverCity(), "N/A"))
                    .parcelType(nvl(d.getParcelCategory(), "N/A"))
                    .date(d.getCreatedAt() != null ? d.getCreatedAt().toLocalDate().format(DF) : "N/A")
                    .earning(0.0) // inter charge field নাই—চাইলে calculate করে দিন
                    .sourceType("INTER_OUTER")
                    .sourcePk(d.getId())
                    .build());
        }

        return list;
    }

    @Transactional
    @Override
    public void accept(String sourceType, Long sourcePk) {
        // ✅ minimal: শুধু demo (status field না থাকলে save করার কিছু নাই)
        // আপনি যদি status যোগ করেন, এখানে ACCEPTED করে save করবেন।
    }

    @Transactional
    @Override
    public void reject(String sourceType, Long sourcePk) {
        // ✅ minimal: শুধু demo
    }

    private String shortText(String s) {
        if (s == null) return "N/A";
        return s.length() > 30 ? s.substring(0, 30) + "..." : s;
    }

    private String nvl(String s, String d) {
        return (s == null || s.isBlank()) ? d : s;
    }
}
