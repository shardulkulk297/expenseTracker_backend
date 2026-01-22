package com.app.expenseTracker.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.expenseTracker.model.Transaction;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("Select t from Transaction t WHERE t.financer.user.username = ?1")
    List<Transaction> getTransactions(String username);

    @Query("Select t from Transaction t WHERE t.transactionDate BETWEEN ?2 AND ?3 AND t.financer.user.username = ?1")
    List<Transaction> getTransactionsByDate(String name, LocalDate startDate, LocalDate endDate);

    @Query("Select t from Transaction t WHERE t.financer.user.username = ?1 LIMIT 5")
    List<Transaction> getFirst5Transactions(String username, Pageable pageable);


}
