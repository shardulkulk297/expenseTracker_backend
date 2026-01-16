package com.app.expenseTracker.service;

import com.app.expenseTracker.model.Financer;
import com.app.expenseTracker.model.User;
import com.app.expenseTracker.repository.FinancerRepository;
import com.app.expenseTracker.repository.UserRepository;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class FinancerService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FinancerRepository financerRepository;

    private Logger logger = Logger.getLogger(FinancerService.class.getName());

    public Financer addFinancer(Financer financer){

        User user = financer.getUser();
        user.setRole("FINANCER");
        user = userService.signup(user);
        financer.setUser(user);

        return financerRepository.save(financer);

    }
}
