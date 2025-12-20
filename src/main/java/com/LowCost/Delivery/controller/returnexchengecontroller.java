package com.LowCost.Delivery.controller;

import com.LowCost.Delivery.model.returnexchengeentity;
import com.LowCost.Delivery.service.returnexchengeservice;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class returnexchengecontroller {

    private final returnexchengeservice service;

    @GetMapping("/return-exchange")
    public String showForm(Model model, HttpSession session) {

        // ✅ Form backing object
        model.addAttribute("returnExchange", new returnexchengeentity());

        // ✅ One-time session message
        Object msg = session.getAttribute("successMsg");
        if (msg != null) {
            model.addAttribute("successMsg", msg.toString());
            session.removeAttribute("successMsg");
        }

        return "Return_Exchange"; 
        // templates/Return_Exchange_Form.html  (আপনার ফাইল নাম অনুযায়ী)
    }

    @PostMapping("/return-exchange")
    public String submitForm(
            @ModelAttribute("returnExchange") returnexchengeentity returnExchange,
            HttpSession session
    ) {
        service.create(returnExchange);

        session.setAttribute("successMsg", "✅ Return/Exchange request submitted successfully!");
        return "redirect:/return-exchange";
    }
}
