package com.app.expenseTracker.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.expenseTracker.model.Transaction;

@RestController
public class TransactionController {

    @PostMapping("/api/transaction/add")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction, Principal principal){

        return ResponseEntity.status(HttpStatus.CREATED).body();

    }
    
}
