package main.transaction;

import main.enums.TransactionType;
import main.exception.InsufficientBalanceException;
import main.model.Account;

public class TransferTransaction extends Transaction {
    private Account sender;
    private Account receiver;

    public TransferTransaction(Account sender, Account receiver, double amount) {
        super(amount, TransactionType.TRANSFER);
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public void execute() throws InsufficientBalanceException {
        this.sender.withdraw(amount);
        this.receiver.deposit(amount);
    }
}
