package com.LowCost.Delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LowCost.Delivery.model.User;
import com.LowCost.Delivery.service.UserService;

@Controller
public class HomeController {

    @GetMapping("/")
    public String viewHomePage() {
        return "index"; // correct
    }
    
     @GetMapping("/incomewith")
    public String incomewith() {
        return "Incom_with_us"; // correct
    }
     @Autowired
    private UserService userService;

 @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "Earn_people/signup";  // signup.html (your frontend)
    }

    // HANDLE REGISTRATION
    @PostMapping("/registers")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.registerUser(user);
            model.addAttribute("success", "Registration successful. Please login.");
            return "Earn_people/login";  // return login page
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "Earn_people/signup"; // reload signup with error
        }
    }

    // SHOW LOGIN PAGE
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "Earn_people/login";  // login.html
    }

    // HANDLE LOGIN
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {

        try {
            User user = userService.login(email, password);
            model.addAttribute("user", user);

            // redirect to dashboard or home page
            return "redirect:/";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "Earn_people/login"; // reload page with error
        }
    }
 
}
