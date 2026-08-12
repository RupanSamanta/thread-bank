package exception;

public class InsufficientBalanceException extends Exception {
    private final double requestedAmount;
    private final double availableBalance;

    public InsufficientBalanceException(double availableBalance, double requestedAmount) {
        super("Insufficient Balance.");
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }

    public double getAvailableBalance() {
        return this.availableBalance;
    }

    public double getRequestedAmount() {
        return this.requestedAmount;
    }
}
