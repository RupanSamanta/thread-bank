package exception;

public class InvalidTransferException extends Exception {
    private int senderAccount;
    private int receiverAccount;

    public InvalidTransferException(int senderAccount, int receiverAccount) {
        super("Invalid transfer from account " + senderAccount + " to account " + receiverAccount);
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
    }

    public int getSenderAccount() {
        return senderAccount;
    }

    public int getReceiverAccount() {
        return receiverAccount;
    }

}
