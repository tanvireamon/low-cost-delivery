package com.LowCost.Delivery.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class admincontroller {

    @GetMapping("/viewadmin")
    public String viewadmindeshbord() {
        return "Admin/admin_dashboard";
    }

    @GetMapping("/vewcomplint")
    public String viewcomplint() {
        return "Admin/complain_box";
    }

    @GetMapping("/complintboxdite")
    public String complintboxdite() {
        return "Admin/complain_details";
    }

    @GetMapping("/customerdetails")
    public String customerdetails() {
        return "Admin/customer_details";
    }

    @GetMapping("/viewcompaniditals")
    public String viewcompaniditals() {
        return "Admin/compani_details";
    }

    @GetMapping("/productdetails")
    public String productdetails() {
        return "Admin/parcel_details";
    }

    @GetMapping("/parcelorderreq")
    public String parcelorderrequest() {
        return "Admin/parcel_order_request";
    }

    @GetMapping("/returndetails")
    public String returendetails() {
        return "Admin/return_details";
    }

    @GetMapping("/riderdetails")
    public String riderdetails() {
        return "Admin/rider_details";
    }

    @GetMapping("/returnexchangecontrol")
    public String returnexchangecontrol() {
        return "Admin/return_exchange_control";
    }

    @GetMapping("/riderhistory")
    public String riderhistory() {
        return "Admin/rider_history";
    }

    @GetMapping("/customerhistory")
    public String customerhistory() {
        return "Admin/customer_history";
    }

    @GetMapping("/sessionlog")
    public String sessionlog() {
        return "Admin/session_log";
    }
 
    
}
