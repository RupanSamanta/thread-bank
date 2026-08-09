package main.transaction;

import main.enums.TransactionType;

public abstract class Transaction {
    protected double amount;
    protected TransactionType type;

    public abstract void execute();
}
