```
ThreadBank/
│
├── src/
│   ├── main/
│   │   ├── Main.java
│   │   ├── bank/
│   │   ├── model/
│   │   ├── transaction/
│   │   ├── exception/
│   │   ├── worker/
│   │   ├── util/
│   │   └── enums/
│   │
│   └── test/            (future)
│
├── README.md
└── .gitignore
```

```
src/
└── main/
    ├── Main.java
    │
    ├── bank/
    │   └── Bank.java
    │
    ├── model/
    │   └── Account.java
    │
    ├── transaction/
    │   ├── Transaction.java
    │   ├── Transactionable.java
    │   ├── DepositTransaction.java
    │   ├── WithdrawTransaction.java
    │   └── TransferTransaction.java
    │
    ├── worker/
    │   └── TransactionWorker.java
    │
    ├── exception/
    │   └── InsufficientBalanceException.java
    │
    ├── enums/
    │   └── TransactionType.java
    │
    └── util/
        ├── RandomTransactionGenerator.java
        ├── InputValidator.java
        └── Constants.java
```