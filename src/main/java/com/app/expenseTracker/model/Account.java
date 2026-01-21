package com.app.expenseTracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountType;
    private String bankName;
    @ManyToOne
    private Financer financer;
    private long balance;
    private long mainBalance;

    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(long mainBalance) {
        this.mainBalance = mainBalance;
    }

    public Financer getFinancer() {
        return financer;
    }

    public void setFinancer(Financer financer) {
        this.financer = financer;
    }

  
}
