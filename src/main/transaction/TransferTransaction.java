package transaction;

import enums.TransactionType;
import exception.InsufficientBalanceException;
import model.Account;

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
