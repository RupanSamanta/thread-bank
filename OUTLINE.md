# ThreadBank - Software Design Document (Version 1.0)

<div align="center">
<strong>Software Design Document</strong>
</div>

## 📘 Project Overview

### 🎯 Objective

Develop a console-based banking system using **Core Java** to revise:

* Java Basics
* Object-Oriented Programming
* Collections Framework
* Exception Handling
* Abstract Classes
* Interfaces
* Multithreading
* Synchronization

No database or GUI will be used. All data remains in memory.

---

# 🏗️ Project Architecture

```
                    Main
                     │
                     ▼
                  Bank
                     │
      ┌──────────────┼──────────────┐
      ▼              ▼              ▼
  Account        Account        Account
      ▲
      │
 Transaction Classes
      ▲
      │
TransactionWorker (Thread)
```

---

# 🧩 Class 1 : Main

## 🧠 Responsibility

Acts as the entry point of the application.

It is responsible only for:

* Creating objects
* Displaying the menu
* Accepting user input
* Invoking methods of Bank

Main should never contain banking logic.

---

## 🔧 Variables

```java
Scanner scanner
Bank bank
```

---

## ⚙️ Member Functions

### main()

Creates the Bank object.

Creates initial accounts.

Displays the menu.

Starts transaction simulation.

---

# 🧾 Class 2 : Account

## 🧠 Responsibility

Represents one customer's bank account.

Every account maintains its own state.

---

## 🗂️ Member Variables

```java
private int accountNumber;
private String holderName;
private double balance;
```

### Explanation

accountNumber

Unique identifier.

Example

```
101
102
103
```

holderName

Stores owner's name.

```
"Rupan"
```

balance

Current available money.

```
15000.50
```

---

## 🛠️ Constructor

```java
Account(int accountNumber,
        String holderName,
        double balance)
```

Purpose

Creates an account with initial values.

---

## ⚙️ Member Functions

### deposit(double amount)

Adds money.

```
Balance += amount
```

---

### withdraw(double amount)

Subtracts money.

Should throw

```
InsufficientBalanceException
```

if balance is insufficient.

---

### display()

Prints account details.

Example

```
101
Rupan
₹12500
```

---

### Getters

```
getBalance()

getAccountNumber()

getHolderName()
```

---

### Setters

Usually not required.

Balance should only change through deposit() or withdraw().

---

# 🏦 Class 3 : Bank

## 🧠 Responsibility

Acts as the central controller.

Stores all accounts.

Performs transfers.

Searches accounts.

Displays reports.

---

## Member Variables

```
Map<Integer, Account> accounts;
```

Why Map?

Searching

```
Account 101
```

takes constant time.

---

## Constructor

Initializes the Map.

---

## Member Functions

### addAccount(Account account)

Adds account.

---

### removeAccount(int id)

Deletes account.

---

### findAccount(int id)

Returns Account object.

Returns null if absent.

---

### deposit(int id, double amount)

Find account.

Call

```
account.deposit()
```

---

### withdraw(int id, double amount)

Find account.

Call

```
account.withdraw()
```

---

### transfer()

Transfer money between accounts.

Flow

```
Withdraw Sender

↓

Deposit Receiver
```

---

### showAllAccounts()

Loops through Map.

Displays every account.

---

### getTotalBankBalance()

Returns total money.

Used after simulation.

---

# 🔄 Class 4 : Transaction

## 🧾 Type

Abstract Class

---

## 🧠 Responsibility

Represents any banking transaction.

Cannot be instantiated directly.

---

## 🗂️ Member Variables

```
protected double amount;

protected TransactionType type;
```

---

## 🛠️ Constructor

Stores amount.

Stores transaction type.

---

## ⚙️ Member Function

```
abstract execute();
```

Every child class must implement it.

---

# ➕ Class 5 : DepositTransaction

## 🔗 Inherits

Transaction

## 🧠 Responsibility

Deposits money.

---

## Variables

```
Account account;
```

---

## execute()

Calls

```
account.deposit(amount)
```

---

# ➖ Class 6 : WithdrawTransaction

## 🔗 Inherits

Transaction

---

## Variables

```
Account account;
```

---

## execute()

Calls

```
withdraw()
```

Throws exception if necessary.

---

# 🔁 Class 7 : TransferTransaction

## 🔗 Inherits

Transaction

---

## Variables

```
Account sender;

Account receiver;
```

---

## execute()

```
sender.withdraw()

↓

receiver.deposit()
```

---

# 🧮 Enum : TransactionType

Purpose

Avoid string comparison.

Values

```
DEPOSIT

WITHDRAW

TRANSFER
```

---

# 🔌 Interface : Transactionable

Purpose

Represents any executable transaction.

```
execute()
```

Every transaction implements this.

---

# ⚠️ Exception

## InsufficientBalanceException

Extends

```
Exception
```

Purpose

Provides meaningful error message.

Example

```
Balance : 300

Withdrawal : 1000

Insufficient Balance
```

---

# 👷 TransactionWorker

## 🧠 Responsibility

Represents one employee processing transactions.

Implements

```
Runnable
```

---

## 🔧 Variables

```
Bank bank;

Random random;
```

---

## ▶️ run()

Pseudo Flow

```
Repeat 20 Times

↓

Select Random Account

↓

Random Transaction

↓

Execute

↓

Sleep Random Time

↓

Repeat
```

---

# 🧵 Thread Creation

Inside Main

```
Thread t1

Thread t2

Thread t3

Thread t4
```

Each thread

```
↓

TransactionWorker

↓

run()
```

---

# 🔐 Synchronization

Shared Resource

```
Account Balance
```

Critical Methods

```
deposit()

withdraw()
```

Should be

```
synchronized
```

Reason

Only one thread may modify balance at a time.

Without synchronization

```
Read

Read

Modify

Modify
```

Data becomes inconsistent.

---

# 🗂️ Collections Used

```
Map<Integer, Account>

(Optional)

List<Transaction>
```

Map

Stores accounts.

List

Stores transaction history.

---

# 🔄 Exception Flow

```
withdraw()

↓

Balance Checked

↓

Enough?

↓

Yes → Continue

↓

No

↓

Throw InsufficientBalanceException

↓

Catch in Main

↓

Display Error
```

---

# ▶️ Complete Execution Flow

```
Program Starts

↓

Create Bank

↓

Create Accounts

↓

Store Accounts

↓

Menu Displayed

↓

User Chooses Simulation

↓

Create Transaction Workers

↓

Create Threads

↓

Threads Execute Transactions

↓

Synchronization Protects Accounts

↓

Threads Finish

↓

Print Final Report

↓

Verify Total Balance

↓

Exit
```

---

# ✨ Future Enhancements

* Transaction History
* File Saving
* JDBC Database
* Login System
* Interest Calculation
* Account Types (Savings/Current)
* ExecutorService
* JavaFX GUI
* REST API using Spring Boot

---

# 🧠 Java Concepts Covered

| Concept            | Where Used                    |
| ------------------ | ----------------------------- |
| Variables          | All classes                   |
| Methods            | All classes                   |
| Constructors       | Account, Bank, Transactions   |
| Encapsulation      | Account                       |
| Inheritance        | Transaction hierarchy         |
| Abstraction        | Transaction                   |
| Interfaces         | Transactionable               |
| Polymorphism       | execute()                     |
| Collections        | Map/List                      |
| Exception Handling | Withdraw operations           |
| Custom Exception   | InsufficientBalanceException  |
| Threads            | TransactionWorker             |
| Synchronization    | deposit(), withdraw()         |
| Enums              | TransactionType               |
| Object Composition | Bank contains Account objects |
