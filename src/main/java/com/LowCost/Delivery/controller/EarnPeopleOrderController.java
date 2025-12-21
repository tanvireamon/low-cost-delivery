package com.LowCost.Delivery.controller;


import com.LowCost.Delivery.service.EarnOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class EarnPeopleOrderController {

    private final EarnOrderService earnOrderService;

    @GetMapping("/earn/available-orders")
    public String availableOrders(Model model) {
        model.addAttribute("orders", earnOrderService.getAvailableOrders());
        return "Earn_people/order"; 
        // B:\Lowcostdelivery\low-cost-delivery\src\main\resources\templates\Earn_people\order.html
    }

    @PostMapping("/earn/orders/{type}/{id}/accept")
    public String accept(@PathVariable("type") String type,
                         @PathVariable("id") Long id) {
        earnOrderService.accept(type, id);
        return "redirect:/earn/available-orders";
    }

    @PostMapping("/earn/orders/{type}/{id}/reject")
    public String reject(@PathVariable("type") String type,
                         @PathVariable("id") Long id) {
        earnOrderService.reject(type, id);
        return "redirect:/earn/available-orders";
    }
}
