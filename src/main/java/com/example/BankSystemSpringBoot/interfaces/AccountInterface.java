package com.example.BankSystemSpringBoot.interfaces;

public interface AccountInterface {
    String printAccountDetails(String name, double balance);
    boolean canWithdraw(double amount);

}
