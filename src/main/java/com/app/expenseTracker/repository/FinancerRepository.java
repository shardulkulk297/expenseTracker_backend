package com.app.expenseTracker.repository;

import com.app.expenseTracker.model.Financer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancerRepository extends JpaRepository<Financer, Integer> {
    @Query("Select f from Financer f WHERE f.user.username = ?1")
    Financer getByUsername(String username);
}
