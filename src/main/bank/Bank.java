package main.bank;
import java.util.HashMap;
import java.util.Map;
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
}
