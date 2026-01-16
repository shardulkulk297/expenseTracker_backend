package com.app.expenseTracker.controller;

import com.app.expenseTracker.model.Financer;
import com.app.expenseTracker.repository.FinancerRepository;
import com.app.expenseTracker.service.FinancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:5173")
public class FinancerController {

    @Autowired
    private FinancerService financerService;

    @PostMapping("/api/financer/add")
    public ResponseEntity<?> addFinancer(@RequestBody Financer financer){
        return ResponseEntity.status(HttpStatus.CREATED).body(financerService.addFinancer(financer));
    }
    

    
}
