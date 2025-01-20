public class BankTransaction {
    private final String transactionId;
    private final double amount;

    public BankTransaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void processTransaction() {
        Logger logger = Logger.getInstance();
        logger.log("Обробка транзакції " + transactionId + " : " + amount);
        logger.log("Транзакція " + transactionId + " оброблена успішно.");
    }
}

