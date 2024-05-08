package com.example.BankSystemSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BankSystemSpringBootApplication {

	public static void main(String[] args) {
		System.out.println();
		System.out.println();
		System.out.println("---------------WELCOME TO BANK SYSTEM------------------- ");
		Scanner scanner = new Scanner(System.in);
		List<Bank> banks = new ArrayList<>();
		Bank bank = null;
		Bank newBank = null;

		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1 - Create a bank");
			System.out.println("2 - Create an account");
			System.out.println("3 - Perform transaction");
			System.out.println("4 - Withdraw amount");
			System.out.println("5 - Deposit amount");
			System.out.println("0 - Exit");
			System.out.print("Enter the option number: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1:
					System.out.println("---------------------------------------------------");
					System.out.println("Enter bank name:");
					String bankName = scanner.nextLine();
					newBank = Bank.createBank(bankName, new ArrayList<>());
					banks.add(newBank);
					bank = newBank;
					System.out.println("---------------------------------------------------");
					break;
				case 2:
					createAccount(scanner, bank, banks);
					break;

				case 3:
					performTransaction(scanner, bank);
					break;
				case 4:
					performWithdraw(scanner, bank);
					break;
				case 5:
					performDeposit(scanner, bank);
					break;
				case 0:
					System.out.println("Exiting program.");
					return;
				default:
					System.out.println("Invalid option. Please try again.");
			}
		}
	}
	public static void performWithdraw(Scanner scanner, Bank bank) {
		try {
			if (bank == null || bank.getListOfAccounts().isEmpty()) {
				System.out.println("No bank or accounts created yet.");
				return;
			}

			System.out.println("---------------------------------------------------");
			System.out.println("Enter your account ID:");
			int accountId = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			Account account = null;
			for (Account acc : bank.getListOfAccounts()) {
				if (acc.getAccountId() == accountId) {
					account = acc;
					break;
				}
			}

			if (account == null) {
				System.out.println("Account not found.");
				return;
			}

			System.out.println("Enter the amount you want to withdraw:");
			double amount = scanner.nextDouble();
			scanner.nextLine(); // Consume newline

			if (amount <= 0) {
				System.out.println("Invalid amount.");
				return;
			}

			if (!account.canWithdraw(amount)) {
				System.out.println("Insufficient balance to perform this withdrawal!");
				return;
			}

			account.withdraw(amount);
			System.out.println("Withdrawal success! New balance: " + account.getBalance());
			System.out.println("---------------------------------------------------");
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public static void performDeposit(Scanner scanner, Bank bank) {
		try {
			if (bank == null || bank.getListOfAccounts().isEmpty()) {
				System.out.println("No bank or accounts created yet.");
				return;
			}
			System.out.println("---------------------------------------------------");
			System.out.println("Enter your account ID:");
			int accountId = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			Account account = null;
			for (Account acc : bank.getListOfAccounts()) {
				if (acc.getAccountId() == accountId) {
					account = acc;
					break;
				}
			}

			if (account == null) {
				System.out.println("Account not found.");
				return;
			}

			System.out.println("Enter the amount you want to deposit:");
			double amount = scanner.nextDouble();
			scanner.nextLine(); // Consume newline

			if (amount <= 0) {
				System.out.println("Invalid amount.");
				return;
			}

			account.deposit(amount);
			System.out.println("Deposit success! New balance: " + account.getBalance());
			System.out.println("---------------------------------------------------");


		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}

	public static void createAccount(Scanner scanner, Bank bank, List<Bank> banks) {
					try {
						if (bank == null) {
							System.out.println("No bank created yet.");
							return;
						}
						System.out.println("---------------------------------------------------");
						System.out.println("Enter account name:");
						String accountName = scanner.nextLine();
						System.out.println("Enter the balance of the account:");
						double balance = scanner.nextDouble();
						Account account = new Account(bank.getListOfAccounts().size() + 1, accountName, balance);
						bank.addAccount(account);
						System.out.println("Your account ID is : " + account.getAccountId());
						System.out.println("Account created successfully.");
						System.out.println("---------------------------------------------------");
					} catch (Exception e) {
						System.out.println("An error occurred: " + e.getMessage());
					}
				}


				public static void performTransaction(Scanner scanner, Bank bank) {
					try {

						if (bank == null || bank.getListOfAccounts().isEmpty()) {
							System.out.println("---------------------------------------------------");
							System.out.println("No bank or accounts created yet.");
							return;
						}
						System.out.println("---------------------------------------------------");

						System.out.println("Enter your account ID:");
						int accountId = scanner.nextInt();
						scanner.nextLine();

						System.out.println("Enter the amount you want to transfer:");
						double amount = scanner.nextDouble();
						scanner.nextLine();

						Account sender = null;
						for (Account acc : bank.getListOfAccounts()) {
							if (acc.getAccountId() == accountId) {
								sender = acc;
								break;
							}
						}

						if (sender == null) {
							System.out.println("Account not found.");
							return;
						}

						Transaction transaction = new Transaction(amount, 0, 0, "", 0);

						if (!transaction.canPerformTransaction(sender.getBalance(), amount)) {
							System.out.println("Insufficient balance to perform this transaction!");
							return;
						}

						System.out.println("Enter fee type (1 for flat fee, 2 for percentage fee):");
						int feeType = scanner.nextInt();
						scanner.nextLine();

						double fee = 0;
						if (feeType == 1) {
							fee = transaction.calculateFee(amount, 10, 0, feeType);
						} else if (feeType == 2) {
							fee = transaction.calculateFee(amount, 0, 5, feeType);
						}

						System.out.println("Enter the account ID you want to transfer to:");
						int recipientAccountId = scanner.nextInt();
						scanner.nextLine();

						System.out.println("Enter the reason of the transfer: ");
						String message = scanner.nextLine();


						Account recipient = null;
						for (Account acc : bank.getListOfAccounts()) {
							if (acc.getAccountId() == recipientAccountId) {
								recipient = acc;
								break;
							}
						}

						if (recipient == null) {
							System.out.println("Recipient account not found.");
							return;
						}

						sender.withdraw(amount + fee);
						recipient.deposit(amount);

						transaction.setOriginatingAccountId(sender.getAccountId());
						transaction.setResultingAccountId(recipient.getAccountId());
						transaction.setTransactionReason(message);

						//sender.addTransaction(transaction);
						//recipient.addTransaction(transaction);


						System.out.println("Transaction success! New balance in " + sender.getName() + ": " + sender.getBalance());
						System.out.println("New balance in " + recipient.getName() + ": " + recipient.getBalance());
						System.out.println("---------------------------------------------------");
					} catch (Exception e) {
						System.out.println("An error occurred: " + e.getMessage());
					}
				}

}
