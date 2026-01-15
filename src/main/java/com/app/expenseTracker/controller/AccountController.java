package com.app.expenseTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.app.expenseTracker.model.Account;
import com.app.expenseTracker.service.AccountService;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/api/account/add")
    private ResponseEntity<?> addAccount(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.addAccount(account));
    }

    @GetMapping("/api/account/balance")
    private ResponseEntity<?> getBalance(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getBalance(account));
    }
    

}
