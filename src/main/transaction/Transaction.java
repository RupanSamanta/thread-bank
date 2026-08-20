package transaction;

import java.math.BigDecimal;
import enums.TransactionType;
import exception.InsufficientBalanceException;

public abstract class Transaction {
    protected BigDecimal amount;
    protected TransactionType type;

    public Transaction(BigDecimal amount, TransactionType type) {
        this.amount = amount;
        this.type = type;
    }

    public abstract void execute() throws InsufficientBalanceException;
}
