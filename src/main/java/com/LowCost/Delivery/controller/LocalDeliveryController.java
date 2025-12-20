package com.LowCost.Delivery.controller;

import com.LowCost.Delivery.model.LocalDeliveryEntity;
import com.LowCost.Delivery.service.LocalDeliveryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LocalDeliveryController {

    private final LocalDeliveryService localDeliveryService;

    @GetMapping("/local-delivery")
    public String showLocalForm(Model model, HttpSession session) {

        // ✅ MUST: Form backing object
        model.addAttribute("localDelivery", new LocalDeliveryEntity());

        // ✅ One-time session success message
        Object msg = session.getAttribute("successMsg");
        if (msg != null) {
            model.addAttribute("successMsg", msg.toString());
            session.removeAttribute("successMsg");
        }

        return "Local_Area_Delivery"; // templates/local_delivery.html
    }

    @PostMapping("/local-delivery")
    public String submitLocalForm(
            @ModelAttribute("localDelivery") LocalDeliveryEntity localDelivery,
            HttpSession session
    ) {
        localDeliveryService.create(localDelivery);
        session.setAttribute("successMsg", "✅ Local delivery request submitted successfully!");
        return "redirect:/local-delivery";
    }
}

