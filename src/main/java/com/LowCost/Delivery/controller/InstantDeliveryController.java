package com.LowCost.Delivery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.LowCost.Delivery.model.InstantDeliveryOrder;
import com.LowCost.Delivery.service.InstantDeliveryOrderService;
import com.LowCost.Delivery.util.PdfGenerator;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class InstantDeliveryController {

    private final InstantDeliveryOrderService orderService;

    // Folder to store uploaded images (you can change path)
    private static final String UPLOAD_DIR = "C:/Users/User/Downloads/img/";

    // SHOW FORM
    @GetMapping("/instant-delivery")
    public String showInstantDeliveryForm(Model model) {
        return "Customer/Instant_Delivery_Form";
        // -> templates/Customer/Instant_Delivery_Form.html
    }
// @GetMapping("/orderD")
// public String oredrdetails() {
//     return "order-details";
// }
@GetMapping("/orderD")
public String oredrdetails(Model model) {
    InstantDeliveryOrder order = orderService.getByOrderId("TEST-ID");
    model.addAttribute("order", order);
    return "order-details";
}

    // private static final String UPLOAD_DIR = "C:/Users/User/Downloads/img/";

    @PostMapping("/instant")
    public String submitInstantOrder(
            @ModelAttribute InstantDeliveryOrder order,
            @RequestParam(name = "parcelImage", required = false) MultipartFile parcelImage,
            RedirectAttributes redirectAttributes) {

        try {
            if (parcelImage != null && !parcelImage.isEmpty()) {

                String fileName = System.currentTimeMillis() + "_" + parcelImage.getOriginalFilename();

                Path uploadPath = Paths.get(UPLOAD_DIR);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Files.copy(parcelImage.getInputStream(), uploadPath.resolve(fileName));
                order.setImageFileName(fileName);
            }
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("error", "Image upload failed!");
            return "redirect:/Customer/instant-delivery";
        }

        if (order.getDeliveryCharge() == null) {
            order.setDeliveryCharge(BigDecimal.valueOf(0));
        }

        InstantDeliveryOrder saved = orderService.createOrder(order);

        redirectAttributes.addFlashAttribute("success",
                "Order placed successfully! ID: " + saved.getOrderId());

        return "redirect:/Customer/instant-delivery";
    }

    @GetMapping("/orderlist")
    public String orderlist(Model model) {
        return "orders-list";
        // -> templates/Customer/Instant_Delivery_Form.html
    }

    // VIEW SINGLE ORDER
    @GetMapping("/orders/{orderId}")
    public String viewOrder(@PathVariable String orderId, Model model) {
        InstantDeliveryOrder order = orderService.getByOrderId(orderId);
        model.addAttribute("order", order);
        return "order-details";
    }

    // DOWNLOAD PDF
    @GetMapping("/orders/pdf/{orderId}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable String orderId) throws Exception {
        InstantDeliveryOrder order = orderService.getByOrderId(orderId);

        byte[] pdfBytes = new PdfGenerator().generateOrderPdf(order);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + orderId + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    // LIST ALL ORDERS
    @GetMapping("/orders/all")
    public String viewAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders-list";
    }
}
