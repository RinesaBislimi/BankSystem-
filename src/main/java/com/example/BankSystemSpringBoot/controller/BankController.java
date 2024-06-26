package com.example.BankSystemSpringBoot.controller;

import com.example.BankSystemSpringBoot.dto.AccountDto;
import com.example.BankSystemSpringBoot.dto.TransactionDto;

import com.example.BankSystemSpringBoot.service.BankService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BankController {
    private final BankService bankService;
    private int accountIdCounter = 1;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/account")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        try {
            accountDto.setAccountId(accountIdCounter++);

            AccountDto createdAccount = bankService.createAccount(accountDto);

            Map<String, Object> response = new HashMap<>();
            response.put("name", createdAccount.getName());
            response.put("balance", createdAccount.getBalance());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create account: " + e.getMessage());
        }
    }


    @PostMapping("/transactions")
    public ResponseEntity<?> performTransaction(@RequestBody TransactionDto transactionDto) {
        try {
            TransactionDto createdTransaction = bankService.performTransaction(transactionDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error performing transaction: " + e.getMessage());
        }
    }
}
