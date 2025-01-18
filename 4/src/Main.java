public class Main {
    public static void main(String[] args) {
        BankTransaction transaction1 = new BankTransaction("T1", 200);
        transaction1.processTransaction();

        BankTransaction transaction2 = new BankTransaction("T2", 500);
        transaction2.processTransaction();

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Logger є одинаком: " + (logger1 == logger2));
    }
}
