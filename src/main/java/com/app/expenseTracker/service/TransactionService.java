package com.app.expenseTracker.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private Logger logger = Logger.getLogger(TransactionService.class.getName());

    public Transaction addTransaction(Transaction transaction, String name) {

        Financer financer = financerRepository.getByUsername(name);
        transaction.setFinancer(financer);
        transaction.setTransactionDate(LocalDate.now());
        transaction.setTransactionTime(Instant.now());
        accountService.updateBalance(transaction.getAccount(), transaction.getAmount());
        logger.info("ACCOUNT BALANCE UPDATED IN THE DATABASE");
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions(String name) {
        List<Transaction> transactions = transactionRepository.getTransactions(name);
        logger.info("ALL TRANSACTIONS");
        return transactions;
    }


    public List<Transaction> getTransactionsByDate(String name, LocalDate startDate, LocalDate endDate){
        List<Transaction> transactions = transactionRepository.getTransactionsByDate(name, startDate, endDate);
        logger.info("TRANSACTIONS BY DATE");
        return transactions;
    }
}
