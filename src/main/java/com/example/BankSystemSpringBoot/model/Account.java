package com.example.BankSystemSpringBoot.model;


import com.example.BankSystemSpringBoot.interfaces.AccountInterface;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountInterface {

    public int accountId;
    public String name;
    public double balance;
    private List<Transaction> transactions;

    public Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String printAccountDetails(String name, double balance) {
        return "----Account name: " + name + " and balance of the account is: " + balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount){
        if(balance - amount >= 0){
            balance-=amount;
        }else{
            System.out.println("Your balance is: $" + balance + " so you can't withdraw $" + amount);
        }
    }
    public void deposit(double amount){
        balance += amount;
        System.out.println("You have added $" + amount);
    }

    public  boolean canWithdraw(double amount){
        return balance -amount >= 0;
    }


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
