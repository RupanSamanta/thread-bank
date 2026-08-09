package main.transaction;

import main.enums.TransactionType;
import main.exception.InsufficientBalanceException;
import main.model.Account;

public class WithdrawTransaction extends Transaction {
    Account account;

    public WithdrawTransaction(Account account, double amount) {
        super(amount, TransactionType.WITHDRAW);
        this.account = account;
    }

    @Override
    public void execute() throws InsufficientBalanceException {
        this.account.withdraw(amount);
    }
}
