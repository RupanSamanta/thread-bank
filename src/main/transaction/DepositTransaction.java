package transaction;

import java.math.BigDecimal;

import enums.TransactionType;
import model.Account;

public class DepositTransaction extends Transaction {
    private Account account;

    public DepositTransaction(Account account, BigDecimal amount) {
        super(amount, TransactionType.DEPOSIT);
        this.account = account;
    }

    @Override
    public void execute() {
        this.account.deposit(amount);
    }
}