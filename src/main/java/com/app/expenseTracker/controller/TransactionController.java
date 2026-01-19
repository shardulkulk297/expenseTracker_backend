package com.app.expenseTracker.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.expenseTracker.model.Transaction;
import com.app.expenseTracker.service.TransactionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("http://localhost:5173")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/transaction/add")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction, Principal principal){

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.addTransaction(transaction, principal.getName()));

    }

    @GetMapping("/api/transaction/getAll")
    public ResponseEntity<?> getAllTransactions(Principal principal){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactions(principal.getName()));
    }

    @GetMapping("/api/transaction/getTransactionsByDate")
    public ResponseEntity<?> getTransactionsByDate(Principal principal, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getTransactionsByDate(principal.getName(), startDate, endDate));
    }

    @GetMapping("/api/transaction/getFirst5Transactions")
    public ResponseEntity<?> getFirst5Transactions(Principal principal) {

        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getFirst5Transactions(principal.getName()));

        
    }
    


    
    
    
}
