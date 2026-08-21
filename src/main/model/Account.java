package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import exception.InsufficientBalanceException;

public class Account {
    private final int accountNumber;
    private String holderName;
    private BigDecimal balance;

    public Account(int accountNumber, String holderName, BigDecimal balance) {
        balance = normalizeCurrency(balance);
        if (balance == null || balance.compareTo(BigDecimal.ZERO) < 0 || 
            holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Initial balance must be zero or a finite positive amount.");
        }
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        amount = normalizeCurrency(amount);
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws InsufficientBalanceException {
        amount = normalizeCurrency(amount);
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (this.balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException(this.balance, amount);
        }
        this.balance = this.balance.subtract(amount);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    private static BigDecimal normalizeCurrency(BigDecimal amount) {
        return amount == null ? null : amount.setScale(2, RoundingMode.HALF_EVEN);
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getHolderName() {
        return this.holderName;
    }
}
