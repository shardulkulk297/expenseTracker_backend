package com.app.expenseTracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.expenseTracker.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("Select a from Account a WHERE a.financer.user.username = ?1")
    List<Account> getAccounts(String name);

    
}
