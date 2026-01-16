package com.app.expenseTracker.service;

import com.app.expenseTracker.model.Financer;
import com.app.expenseTracker.model.User;
import com.app.expenseTracker.repository.FinancerRepository;
import com.app.expenseTracker.repository.UserRepository;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Logger logger = Logger.getLogger(UserService.class.getName());

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
        logger.info("Getting user from Auth User table");

        switch (userToFind.getRole()) {
            case "FINANCER" -> {
                Financer financer = financerRepository.getByUsername(username);
                logger.info("Getting the financer from the financer table");
                return financer;
            }

            default -> {
                return null;
            }

        }
    }
}
