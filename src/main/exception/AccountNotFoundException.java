package exception;

public class AccountNotFoundException extends Exception {
    private final int accountNumber;

    public AccountNotFoundException(int accountNumber) {
        super("Account with number " + accountNumber + " not found.");
        this.accountNumber = accountNumber;
    }

    public int getRequestedAccountNumber() {
        return this.accountNumber;
    }
}
