package exception;

public class AccountAlreadyExistsException extends Exception {
    private int accountNumber;

    public AccountAlreadyExistsException(int accountNumber) {
        super("Account with number " + accountNumber + " already exists.");
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
}
