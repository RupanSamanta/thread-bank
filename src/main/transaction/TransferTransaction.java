package main.transaction;

import main.enums.TransactionType;
import main.exception.InsufficientBalanceException;
import main.model.Account;

public class TransferTransaction extends Transaction {
    private Account sender;
    private Account reciever;

    public TransferTransaction(Account sender, Account reciever, double amount) {
        super(amount, TransactionType.TRANSFER);
        this.sender = sender;
        this.reciever = reciever;
    }

    @Override
    public void execute() throws InsufficientBalanceException {
        this.sender.withdraw(amount);
        this.reciever.deposit(amount);
    }
}
