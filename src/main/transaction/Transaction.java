package transaction;

import enums.TransactionType;
import exception.InsufficientBalanceException;

public abstract class Transaction {
    protected double amount;
    protected TransactionType type;

    public Transaction(double amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }

    public abstract void execute() throws InsufficientBalanceException;
}
