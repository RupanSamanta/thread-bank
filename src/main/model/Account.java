package main.model;

public class Account {
    private int accountNumber;
    private String holderName;
    private double balance;

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public void display() {
        System.out.println("\tAccount Number: " + this.accountNumber);
        System.out.println("\tHolder Name: " + this.holderName);
        System.out.println("\tBalance: ₹" + this.balance);
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getHolderName() {
        return this.holderName;
    }
}
