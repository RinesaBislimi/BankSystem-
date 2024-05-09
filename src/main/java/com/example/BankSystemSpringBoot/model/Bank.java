package com.example.BankSystemSpringBoot.model;

import java.util.List;

public class Bank {
    private String bankName;
    private List<Account> listOfAccounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;

    public Bank(String bankName, List<Account> listOfAccounts, double totalTransactionFeeAmount, double totalTransferAmount, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        this.bankName = bankName;
        this.listOfAccounts = listOfAccounts;
        this.totalTransactionFeeAmount = totalTransactionFeeAmount;
        this.totalTransferAmount = totalTransferAmount;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void addAccount(Account account) {
        listOfAccounts.add(account);
    }

    public List<Account> getListOfAccounts() {
        return listOfAccounts;
    }

    public void setListOfAccounts(List<Account> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public void setTotalTransactionFeeAmount(double totalTransactionFeeAmount) {
        this.totalTransactionFeeAmount = totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void setTotalTransferAmount(double totalTransferAmount) {
        this.totalTransferAmount = totalTransferAmount;
    }

    public double getTransactionFlatFeeAmount() {
        return transactionFlatFeeAmount;
    }

    public void setTransactionFlatFeeAmount(double transactionFlatFeeAmount) {
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
    }

    public double getTransactionPercentFeeValue() {
        return transactionPercentFeeValue;
    }

    public void setTransactionPercentFeeValue(double transactionPercentFeeValue) {
        this.transactionPercentFeeValue = transactionPercentFeeValue;
    }

    public static Bank createBank(String bankName, List<Account> listOfAccounts) {
        // Provide default values or ask the user for input
        Bank bank = new Bank(bankName, listOfAccounts, 0, 0, 5.0, 2.0);
        System.out.println("Bank created: " + bankName);
        return bank;
    }


}
