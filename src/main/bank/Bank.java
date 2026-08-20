package bank;

import java.math.BigDecimal;
import model.Account;
import exception.*;
import transaction.*;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Integer, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) throws AccountAlreadyExistsException {
        if (accounts.containsKey(account.getAccountNumber())) {
            throw new AccountAlreadyExistsException(account.getAccountNumber());
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public void removeAccount(int accountNumber) throws AccountNotFoundException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException(accountNumber);
        }
        accounts.remove(accountNumber);
    }

    public Account findAccount(int accountNumber) throws AccountNotFoundException {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException(accountNumber);
        }
        return account;
    }

    public void viewAccountDetails(int accountNumber) throws AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        System.out.println("\nAccount Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getHolderName());
        System.out.println("Balance: " + account.getBalance());
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

    public void deposit(int accountNumber, BigDecimal amount) throws InsufficientBalanceException, AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        Transaction transaction = new DepositTransaction(account, amount);
        transaction.execute();
    }

    public void withdraw(int accountNumber, BigDecimal amount)
            throws InsufficientBalanceException, AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        Transaction transaction = new WithdrawTransaction(account, amount);
        transaction.execute();
    }

    public void transfer(int senderId, int receiverId, BigDecimal amount) throws InsufficientBalanceException, AccountNotFoundException, InvalidTransferException {
        if (senderId == receiverId) {
            throw new InvalidTransferException(senderId, receiverId);
        }
        Account sender = this.findAccount(senderId);
        Account receiver = this.findAccount(receiverId);
        Transaction transaction = new TransferTransaction(sender, receiver, amount);
        transaction.execute();
    }

    public BigDecimal getBankBalance(int accountNumber) throws AccountNotFoundException {
        Account account = this.findAccount(accountNumber);
        return account.getBalance();
    }
}
