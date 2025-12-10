package com.LowCost.Delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    // @GetMapping("/login")
    // public String showLoginPage() {
    //     return "login";  // login.html page
    // }

    // @PostMapping("/loginsave")
    // public String login(@RequestParam String email,
    //                     @RequestParam String password,
    //                     Model model) {

    //     User user = userService.loginUser(email, password);

    //     if (user != null) {
    //         model.addAttribute("msg", "Login Successful!");
    //         return "redirect:/dashboard"; // Change your page
    //     } else {
    //         model.addAttribute("error", "Invalid email or password");
    //         return "login";
    //     }
    // }
     @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        User user = userService.loginUser(email, password);

        if (user != null) {
            return "redirect:/dashboard";   // change your page
        }

        model.addAttribute("error", "Invalid email or password");
        return "login";
    }
  @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";   // signup.html
    }

    @PostMapping("/signupsave")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String password,
            @RequestParam String gender,
            Model model) {

        User user = new User(username, email, phone, password, gender);
        userService.registerUser(user);

        model.addAttribute("success", "Registration Successful! Please login.");
        return "login";   // redirect to login page
    }
 
}
