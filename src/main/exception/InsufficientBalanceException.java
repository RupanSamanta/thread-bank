package exception;

import java.math.BigDecimal;

public class InsufficientBalanceException extends Exception {
    private final BigDecimal requestedAmount;
    private final BigDecimal availableBalance;

    public InsufficientBalanceException(BigDecimal availableBalance, BigDecimal requestedAmount) {
        super("Insufficient Balance.");
        this.availableBalance = availableBalance;
        this.requestedAmount = requestedAmount;
    }

    public BigDecimal getAvailableBalance() {
        return this.availableBalance;
    }

    public BigDecimal getRequestedAmount() {
        return this.requestedAmount;
    }
}
