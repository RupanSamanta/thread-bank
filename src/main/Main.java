import bank.Bank;
import exception.*;
import model.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Bank
        Bank bank = new Bank();

        boolean running = true;
        while (running) {

            System.out.println("\n===========  THREADBANK  ===========");
            System.out.println("1. Add Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Show Accounts");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Transfer");
            System.out.println("7. Exit");
            System.out.println("-----------------------------------");

            System.out.print("Enter choice: ");

            try {
                int choice = scanner.nextInt();
                int accountNumber;
                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextInt();

                        scanner.nextLine(); // Consume the newline character
                        System.out.print("Enter account holder name: ");
                        String accountHolder = scanner.nextLine();

                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();

                        scanner.nextLine(); // Consume the newline character
                        Account newAccount = new Account(accountNumber, accountHolder, initialBalance);
                        bank.addAccount(newAccount);

                        System.out.println("Account added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter account number: ");
                        accountNumber = scanner.nextInt();
                        bank.viewAccountDetails(accountNumber);
                        break;

                    case 3:
                        bank.showAllAccounts();
                        break;

                    case 4:
                        System.out.print("Enter account number: ");
                        int depositAccount = scanner.nextInt();

                        System.out.print("Enter amount: ");
                        double depositAmount = scanner.nextDouble();

                        bank.deposit(depositAccount, depositAmount);

                        System.out.println("Deposit successful.");
                        break;

                    case 5:
                        System.out.print("Enter account number: ");
                        int withdrawAccount = scanner.nextInt();

                        System.out.print("Enter amount: ");
                        double withdrawAmount = scanner.nextDouble();

                        bank.withdraw(withdrawAccount, withdrawAmount);

                        System.out.println("Withdrawal successful.");
                        break;

                    case 6:
                        System.out.print("Enter sender account: ");
                        int sender = scanner.nextInt();

                        System.out.print("Enter receiver account: ");
                        int receiver = scanner.nextInt();

                        System.out.print("Enter amount: ");
                        double transferAmount = scanner.nextDouble();

                        bank.transfer(sender, receiver, transferAmount);

                        System.out.println("Transfer successful.");
                        break;

                    case 7:
                        running = false;
                        System.out.println("Thank you for using ThreadBank.");
                        break;

                    default:
                        System.out.println("Invalid choice.");

                }

            } 
            catch (InsufficientBalanceException e) {
                System.out.println("\nTransaction failed.");
                System.out.println(e.getMessage());
            } 
            catch (AccountNotFoundException e) {
                System.out.println("\n" + e.getMessage());
            }
            catch (Exception e) {
                System.out.println("\nSomething went wrong: " + e.getMessage());
            }
        }

        scanner.close();
    }
}