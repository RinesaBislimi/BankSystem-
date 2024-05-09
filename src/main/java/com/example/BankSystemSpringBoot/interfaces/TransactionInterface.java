package com.example.BankSystemSpringBoot.interfaces;
public interface TransactionInterface {
    double calculateFee(double amount, double flatFee, double percentFee, int feeType);
    String getTransactionType();


}
