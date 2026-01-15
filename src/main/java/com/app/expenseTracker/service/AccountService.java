package com.app.expenseTracker.service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.expenseTracker.model.Account;
import com.app.expenseTracker.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account addAccount(Account account) {
       
        return accountRepository.save(account);
       
    }

    public int getBalance(Account account) {

        return 0;
       
    }
    
}
