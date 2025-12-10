package com.LowCost.Delivery.service;

import com.LowCost.Delivery.model.User;

public interface UserService {
    // User registerUser(User user);
    // User loginUser(String email, String rawPassword);
    
    User registerUser(User user);

    User loginUser(String email, String password);
}
