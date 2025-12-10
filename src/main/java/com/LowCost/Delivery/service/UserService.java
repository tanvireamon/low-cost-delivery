package com.LowCost.Delivery.service;

import com.LowCost.Delivery.model.User;

public interface UserService {
   
     User registerUser(User user);
    User login(String email, String password);
}
