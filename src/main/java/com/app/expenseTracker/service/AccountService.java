package com.app.expenseTracker.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public void updateBalance(Account account, int amount) {
       account.setBalance(account.getBalance() - amount);

       accountRepository.save(account);
;    }

    public List<Account> getAccounts(String name) {
       return accountRepository.getAccounts(name);
    }
    
}
