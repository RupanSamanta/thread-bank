package transaction;

import enums.TransactionType;
import model.Account;
import exception.*;

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
        try {
            this.sender.withdraw(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        this.receiver.deposit(amount);
    }
}
