package main.transaction;

import main.enums.TransactionType;
import main.model.Account;

public class DepositTransaction extends Transaction {
    private Account account;

    public DepositTransaction(Account account, double amount) {
        super(amount, TransactionType.DEPOSIT);
        this.account = account;
    }

    public void execute() {
        this.account.deposit(amount);
    }
}