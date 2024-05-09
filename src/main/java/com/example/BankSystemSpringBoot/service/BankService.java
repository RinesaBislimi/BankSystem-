package com.example.BankSystemSpringBoot.service;

import com.example.BankSystemSpringBoot.model.Account;
import com.example.BankSystemSpringBoot.model.Transaction;
import com.example.BankSystemSpringBoot.dto.AccountDto;
import com.example.BankSystemSpringBoot.dto.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    private final List<Account> accounts = new ArrayList<>();
    private int accountIdCounter = 1;

    public AccountDto createAccount(AccountDto accountDto) {
        Account account = new Account(accountIdCounter++, accountDto.getName(), accountDto.getBalance());
        accounts.add(account);
        return accountDto;
    }

    public TransactionDto performTransaction(TransactionDto transactionDto) {
        Account originatingAccount = findAccountById(transactionDto.getOriginatingAccountId());
        Account resultingAccount = findAccountById(transactionDto.getResultingAccountId());

        if (originatingAccount == null || resultingAccount == null) {
            throw new IllegalArgumentException("Invalid account ID");
        }

        if (originatingAccount.getBalance() < transactionDto.getAmount()) {
            throw new IllegalArgumentException("Insufficient balance for transaction");
        }

        originatingAccount.withdraw(transactionDto.getAmount());
        resultingAccount.deposit(transactionDto.getAmount());


        return transactionDto;
    }



    private Account findAccountById(int accountId) {
        return accounts.stream()
                .filter(account -> account.getAccountId() == accountId)
                .findFirst()
                .orElse(null);
    }


}
