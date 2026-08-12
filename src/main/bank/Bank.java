package bank;

import java.util.HashMap;
import java.util.Map;

import exception.InsufficientBalanceException;
import model.Account;
import transaction.DepositTransaction;
import transaction.Transaction;
import transaction.TransferTransaction;
import transaction.WithdrawTransaction;

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

    public void showAccounts() {
        System.out.println("\nAcc. No.\tName\t\tBalance");
        accounts.forEach((key, account) -> {
            System.out.println(key + "\t\t" + account.getHolderName() + "\t\t" + account.getBalance());
        });
    }

    public void deposit(int accountNumber, double amount) throws InsufficientBalanceException {
        Account account = this.findAccount(accountNumber);
        Transaction transaction = new DepositTransaction(account, amount);
        transaction.execute();
    }

    public void withdraw(int accountNumber, double amount) throws InsufficientBalanceException {
        Account account = this.findAccount(accountNumber);
        Transaction transaction = new WithdrawTransaction(account, amount);
        transaction.execute();
    }

    public void transfer(int senderId, int receiverId, double amount) throws InsufficientBalanceException {
        Account sender = this.findAccount(senderId);
        Account receiver = this.findAccount(receiverId);
        Transaction transaction = new TransferTransaction(sender, receiver, amount);
        transaction.execute();
    }

    public double getBankBalance(int accountNumber) {
        Account account = this.findAccount(accountNumber);
        return account.getBalance();
    }
}
