package com.LowCost.Delivery.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.LowCost.Delivery.model.interoutercityentity;
import com.LowCost.Delivery.service.interouterservice;

@Controller
@RequiredArgsConstructor
public class interoutercitycontroller {

    private final interouterservice deliveryRequestService;

    // Form page open
    @GetMapping("/inter-outer-delivery")
    public String showForm(Model model, HttpSession session) {

        // Form backing object
        model.addAttribute("deliveryRequest", new interoutercityentity());

        // Read session success message and remove it (one-time display)
        Object msg = session.getAttribute("successMsg");
        if (msg != null) {
            model.addAttribute("successMsg", msg.toString());
            session.removeAttribute("successMsg");
        }

        return "Inter_Outer_City_Delivery"; // templates/inter_outer_delivery.html
    }
    @PostMapping("/inter-outer-delivery")
    public String submitForm(@ModelAttribute interoutercityentity deliveryRequest,
            HttpSession session) {

        deliveryRequestService.create(deliveryRequest);

        session.setAttribute("successMsg", "✅ Delivery request submitted successfully!");
        return "redirect:/inter-outer-delivery";
    }

}
