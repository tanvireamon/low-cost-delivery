package com.LowCost.Delivery.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LowCost.Delivery.model.Complaint;
import com.LowCost.Delivery.service.ComplaintService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

public class ComplaintController {

    private final ComplaintService complaintService;
  
      
    // Form submit
    @PostMapping("/complaints")
    public String submitComplaint(@ModelAttribute Complaint complaint,
                                  RedirectAttributes redirectAttributes) {

        complaintService.saveComplaint(complaint);
        redirectAttributes.addFlashAttribute("successMessage",
                "Your complaint has been submitted successfully.");

        // same page e back
        return "redirect:/";
    }
}
