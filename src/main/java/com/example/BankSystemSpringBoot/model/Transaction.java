package com.example.BankSystemSpringBoot.model;

import com.example.BankSystemSpringBoot.interfaces.TransactionInterface;

public class Transaction implements TransactionInterface {

    private double amount;
    private int originatingAccountId;
    private int resultingAccountId;
    private String transactionReason;
    private double fee;

    public Transaction(double amount, int originatingAccountId, int resultingAccountId, String transactionReason, double fee) {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.transactionReason = transactionReason;
        this.fee=fee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getFee() {

        return fee;
    }


    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getOriginatingAccountId() {
        return originatingAccountId;
    }

    public void setOriginatingAccountId(int originatingAccountId) {
        this.originatingAccountId = originatingAccountId;
    }

    public int getResultingAccountId() {
        return resultingAccountId;
    }

    public void setResultingAccountId(int resultingAccountId) {
        this.resultingAccountId = resultingAccountId;
    }

    public String getTransactionReason() {
        return transactionReason;
    }

    public void setTransactionReason(String transactionReason) {
        this.transactionReason = transactionReason;
    }

    @Override
    public double calculateFee(double amount, double flatFee, double percentFee, int feeType) {
        switch (feeType) {
            case 1:
                System.out.println("Total flat fee is $10");
                return flatFee;
            case 2:
                System.out.println("Total fee in percent is 5%");
                return (percentFee / 100) * amount;
            default:
                System.out.println("Invalid choice. Using default flat fee.");
                return flatFee;
        }
    }

    @Override
    public String getTransactionType() {
        return "";
    }

    public static boolean canPerformTransaction(double balance, double amount) {
        return balance >= amount;
    }
}
