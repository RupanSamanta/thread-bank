package main.bank;
import java.util.HashMap;
import java.util.Map;

import main.exception.InsufficientBalanceException;
import main.model.Account;

public class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(int accountNumber) {
        accounts.remove(accountNumber);
    }

    public Account findAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        Account account = this.findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) throws InsufficientBalanceException {
        Account account = this.findAccount(accountNumber);
        account.withdraw(amount);
    }

    public void transfer(int senderId, int receiverId, double amount) throws InsufficientBalanceException {
        Account sender = this.findAccount(senderId);
        Account receiver = this.findAccount(receiverId);

        sender.withdraw(amount);
        receiver.deposit(amount);
    }

    public double getBankBalance(int accountNumber) {
        Account account = this.findAccount(accountNumber);
        return account.getBalance();
    }
}
