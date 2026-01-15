package com.app.expenseTracker.service;

import com.app.expenseTracker.model.Financer;
import com.app.expenseTracker.model.User;
import com.app.expenseTracker.repository.FinancerRepository;
import com.app.expenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private FinancerRepository financerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    public User signup(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);

    }

    public Object getLoggedInUserDetails(String username) {

        User userToFind = userRepository.getByUsername(username);

        switch (userToFind.getRole()) {
            case "FINANCER" -> {
                Financer financer = financerRepository.getByUsername(username);
                return financer;
            }

            default -> {
                return null;
            }

        }
    }
}
