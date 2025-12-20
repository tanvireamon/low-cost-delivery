package com.LowCost.Delivery.controller;

import com.LowCost.Delivery.model.ParcelTrackingEntity;
import com.LowCost.Delivery.service.ParcelTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ParcelTrackingController {

    private final ParcelTrackingService trackingService;

    @GetMapping("/track-parcel")
    public String showTrackPage() {
        return "Track_Your_Parcel"; // templates/Track_Parcel.html
    }

    @PostMapping("/track-parcel")
    public String trackParcel(@RequestParam String trackingId,
                              @RequestParam(required = false) String phone,
                              Model model) {

        model.addAttribute("trackingIdValue", trackingId);
        model.addAttribute("phoneValue", phone);

        var opt = trackingService.findByTrackingId(trackingId);
        if (opt.isEmpty()) {
            model.addAttribute("errorMsg", "❌ Tracking ID not found. Please check and try again.");
            return "Track_Your_Parcel";
        }

        ParcelTrackingEntity t = opt.get();

        // (optional) phone মিলাতে চাইলে এখানে verify করতে পারেন
        // if (phone != null && !phone.isBlank() && t.getPhone() != null && !phone.equals(t.getPhone())) { ... }

        model.addAttribute("trackingResult", t);

        // timeline step index
        int stepIndex = statusToIndex(t.getCurrentStatus());
        model.addAttribute("stepIndex", stepIndex);

        // display labels (optional)
        model.addAttribute("statusLabelMap", Map.of(
                "Pickup", "Pickup",
                "Sorting", "Sorting",
                "On the way", "On the way",
                "Destination", "Destination",
                "Delivered", "Delivered"
        ));

        return "Track_Your_Parcel";
    }

    private int statusToIndex(String status) {
        if (status == null) return 0;
        return switch (status.trim()) {
            case "Pickup" -> 0;
            case "Sorting" -> 1;
            case "On the way" -> 2;
            case "Destination" -> 3;
            case "Delivered" -> 4;
            default -> 0;
        };
    }
}
