package transaction;

import enums.TransactionType;
import model.Account;

public class DepositTransaction extends Transaction {
    private Account account;

    public DepositTransaction(Account account, double amount) {
        super(amount, TransactionType.DEPOSIT);
        this.account = account;
    }

    @Override
    public void execute() {
        this.account.deposit(amount);
    }
}