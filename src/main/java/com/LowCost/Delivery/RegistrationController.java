package com.LowCost.Delivery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration-box")
    public String registrationPage() {
        return "registration-box"; // registration-box.html inside templates
    }
}
