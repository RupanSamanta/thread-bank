package main.transaction;

import main.enums.TransactionType;
import main.exception.InsufficientBalanceException;

public abstract class Transaction {
    protected double amount;
    protected TransactionType type;

    public Transaction(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }

    public abstract void execute() throws InsufficientBalanceException;
}
