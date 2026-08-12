package transaction;

import enums.TransactionType;
import exception.InsufficientBalanceException;
import model.Account;

public class WithdrawTransaction extends Transaction {
    private Account account;

    public WithdrawTransaction(Account account, double amount) {
        super(amount, TransactionType.WITHDRAW);
        this.account = account;
    }

    @Override
    public void execute() throws InsufficientBalanceException {
        this.account.withdraw(amount);
    }
}
