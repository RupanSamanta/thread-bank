package bank;

import model.Account;
import exception.*;
import transaction.*;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        for (Account existingAccount : accounts.values()) {
            if (existingAccount.getAccountNumber() == account.getAccountNumber()) {
                System.out.println("Account with number " + account.getAccountNumber() + " already exists.");
                return;
            }
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(int accountNumber) {
        accounts.remove(accountNumber);
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }
        return account;
    }

    public void viewAccountDetails(int accountNumber) {
        try {
            Account account = this.findAccount(accountNumber);
            System.out.println("\nAccount Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Balance: " + account.getBalance());
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("\nNo accounts found.");
            return;
        }
        System.out.println("\nAcc. No.\tName\t\tBalance");
        accounts.forEach((key, account) -> {
            System.out.println(key + "\t\t" + account.getHolderName() + "\t\t" + account.getBalance());
        });
    }

    public void deposit(int accountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        Transaction transaction = new DepositTransaction(account, amount);
        transaction.execute();
    }

    public void withdraw(int accountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        Transaction transaction = new WithdrawTransaction(account, amount);
        transaction.execute();
    }

    public void transfer(int senderId, int receiverId, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        if (senderId == receiverId) {
            System.out.println("Sender and receiver cannot be the same.");
            return;
        }
        Account sender = this.findAccount(senderId);
        Account receiver = this.findAccount(receiverId);
        Transaction transaction = new TransferTransaction(sender, receiver, amount);
        transaction.execute();
    }

    public double getBankBalance(int accountNumber) throws AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        return account.getBalance();
    }
}
