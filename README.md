# ThreadBank

A console-based Java banking transaction simulator designed to demonstrate Core Java and Advanced Java concepts through a structured, object-oriented application.

## Features

- Bank account management
- Account lookup using account number
- Deposit operations
- Withdrawal operations
- Account-to-account transfers
- Custom exception handling
- Transaction abstraction and polymorphism
- Transaction type enumeration
- Transaction history
- Multithreaded transaction processing
- Thread synchronization and concurrency handling

## Technologies

- Java
- Object-Oriented Programming
- Java Collections Framework
- Exception Handling
- Multithreading
- Synchronization

## Project Structure

thread-bank/
│
├── src/
│   └── main/
│       ├── Main.java
│       │
│       ├── bank/
│       │   └── Bank.java
│       │
│       ├── model/
│       │   └── Account.java
│       │
│       ├── transaction/
│       │   ├── Transaction.java
│       │   ├── DepositTransaction.java
│       │   ├── WithdrawTransaction.java
│       │   └── TransferTransaction.java
│       │
│       ├── exception/
│       │   └── InsufficientBalanceException.java
│       │
│       └── enums/
│           └── TransactionType.java
│
├── .gitignore
└── README.md

## Architecture

                    Bank
                     │
                 Accounts
                     │
                     ▼
                Transactions
              /       |       \
             ▼        ▼        ▼
         Deposit   Withdraw   Transfer
             \        |        /
              └───────┼───────┘
                      ▼
                   Account

## Core Java Concepts

The project covers:

- Classes and Objects
- Constructors
- Encapsulation
- Inheritance
- Abstraction
- Method Overriding
- Polymorphism
- Collections
- Enums
- Custom Exceptions
- "throw" and "throws"
- Exception Handling
- Packages
- Multithreading
- "Runnable"
- Synchronization
- Race Conditions

## Transaction Flow

Main
 │
 ▼
Bank
 │
 ▼
Transaction
 │
 ├── DepositTransaction
 ├── WithdrawTransaction
 └── TransferTransaction
 │
 ▼
Account

## Requirements

- JDK 8 or later

Verify the installation:

java -version
javac -version

## Running the Project

From the project root:

mkdir -p out
javac -d out $(find src/main -name "*.java")

Run the application:

java -cp out Main

Windows

The project can be compiled and executed using an IDE such as VS Code or IntelliJ IDEA, or by providing the source files to "javac" manually.

Development Status

- [x] Account model
- [x] Bank management
- [x] Deposit
- [x] Withdrawal
- [x] Transfer
- [x] Custom exception
- [x] Transaction hierarchy
- [ ] Console menu
- [ ] Transaction history
- [ ] Transaction worker
- [ ] Multithreading
- [ ] Synchronization
- [ ] Concurrency testing

Purpose

ThreadBank is an educational project focused on applying Java fundamentals and Advanced Java concepts in a practical application.

License

This project is intended for educational purposes.