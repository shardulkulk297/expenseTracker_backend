package com.app.expenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.expenseTracker.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    
}
