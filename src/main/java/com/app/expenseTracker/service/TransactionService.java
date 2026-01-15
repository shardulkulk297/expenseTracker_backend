package com.app.expenseTracker.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseTracker.model.Financer;
import com.app.expenseTracker.model.Transaction;
import com.app.expenseTracker.repository.FinancerRepository;
import com.app.expenseTracker.repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private FinancerRepository financerRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;

    public Transaction addTransaction(Transaction transaction, String name) {

        Financer financer = financerRepository.getByUsername(name);
        transaction.setFinancer(financer);
        transaction.setTransactionDate(LocalDate.now());
        transaction.setTransactionTime(Instant.now());
        accountService.updateBalance(transaction.getAccount(), transaction.getAmount());
        return transactionRepository.save(transaction);
    }
      

    
}
