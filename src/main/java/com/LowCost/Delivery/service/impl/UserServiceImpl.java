package com.LowCost.Delivery.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LowCost.Delivery.model.User;
import com.LowCost.Delivery.repository.UserRepository;
import com.LowCost.Delivery.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // @Override
    // public User registerUser(User user) {
    //     // store password as plain text (not recommended for real systems)
    //     return userRepository.save(user);
    // }

    // @Override
    // public User loginUser(String email, String rawPassword) {

    //     User user = userRepository.findByEmail(email);

    //     // direct comparing without bcrypt
    //     if (user != null && user.getPassword().equals(rawPassword)) {
    //         return user;
    //     }

    //     return null;
    // }
    
      @Override
    public User registerUser(User user) {
        // Save plain password
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String rawPassword) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(rawPassword)) {
            return user;
        }

        return null;
    }
}
