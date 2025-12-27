package com.LowCost.Delivery.controller;


import com.LowCost.Delivery.service.ComplaintServiceA;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/complaints")
public class AdminComplaintController {

    private final ComplaintServiceA complaintService;

    //  List page
    @GetMapping
    public String list(Model model, HttpSession session) {
        model.addAttribute("complaints", complaintService.getAll());

        Object msg = session.getAttribute("successMsg");
        if (msg != null) {
            model.addAttribute("successMsg", msg.toString());
            session.removeAttribute("successMsg");
        }
        return "Admin/complain_box"; // templates/admin/complaints.html
    }

    //  Details page
    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        model.addAttribute("complaint", complaintService.getById(id));
        return "Admin/complain_details"; // templates/Admin/complain_details.html
    }

    //  Reply save (optional)
    @PostMapping("/{id}/reply")
    public String reply(@PathVariable String id,
                        @RequestParam("adminReply") String adminReply,
                        HttpSession session) {
        complaintService.saveReply(id, adminReply);
        session.setAttribute("successMsg", " Reply saved!");
        return "redirect:/admin/complaints/" + id;
    }

    //  Resolve
    @PostMapping("/{id}/resolve")
    public String resolve(@PathVariable String id,
                          @RequestParam("adminReply") String adminReply,
                          HttpSession session) {
        complaintService.resolve(id, adminReply);
        session.setAttribute("successMsg", " Complaint resolved!");
        return "redirect:/admin/complaints";
    }
}
