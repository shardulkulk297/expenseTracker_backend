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
    private int balance;
    private int mainBalance;

    
    
    
    

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMainBalance() {
        return mainBalance;
    }

    public void setMainBalance(int mainBalance) {
        this.mainBalance = mainBalance;
    }

    public Financer getFinancer() {
        return financer;
    }

    public void setFinancer(Financer financer) {
        this.financer = financer;
    }

  
}
