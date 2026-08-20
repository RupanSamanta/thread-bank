package transaction;

import java.math.BigDecimal;
import enums.TransactionType;
import model.Account;
import exception.*;

public class TransferTransaction extends Transaction {
    private Account sender;
    private Account receiver;

    public TransferTransaction(Account sender, Account receiver, BigDecimal amount) {
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
