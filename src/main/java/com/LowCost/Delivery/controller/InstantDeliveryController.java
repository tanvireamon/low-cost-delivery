package com.LowCost.Delivery.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.LowCost.Delivery.model.InstantDelivery;
import com.LowCost.Delivery.service.InstantDeliveryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class InstantDeliveryController {

    private final InstantDeliveryService service;

    @GetMapping("/customerdashbore")
    public String custmerdeshbored() {
        return "customer-dashboard";
    }

    @GetMapping("/instant-delivery")
    public String showForm() {
        return "Instant_Delivery_Form";
    }

    @GetMapping("/orders-list")
    public String orderslist() {
        return "orders-list";
    }

    @GetMapping("/order-details")
    public String orderdetails() {
        return "order-details";
    }

    @PostMapping(value = "/instant", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleForm(
            @ModelAttribute InstantDelivery delivery,
            @RequestParam(value = "parcelImage", required = false) MultipartFile file,
            Model model) throws IOException {

        if (file != null && !file.isEmpty()) {

            // ✅ External directory (SAFE)
            String uploadDir = "B:/Lowcostdelivery/uploads/";
            File uploadPath = new File(uploadDir);

            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            // ✅ Correct path joining
            File dest = new File(uploadPath, fileName);
            file.transferTo(dest);

            // Save relative URL
            delivery.setParcelImagePath("/uploads/" + fileName);
        }

        delivery.setDeliveryCharge(150.0);
        service.save(delivery);

        model.addAttribute("successMessage", "Delivery request submitted successfully!");

        return "redirect:/";
    }

    // @GetMapping("/interncitydelivery")
    // public String intercityString() {
    //     return "Inter_Outer_City_Delivery";
    // }

    // @GetMapping("/localareadelivery")
    // public String loalareadeliveryString() {
    //     return "Local_Area_Delivery";
    // }

    @GetMapping("/track")
    public String trackString() {
        return "Track_Your_Parcel";
    }

}
