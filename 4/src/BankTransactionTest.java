import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BankTransactionTest {

    @Test
    public void testProcessTransaction() {
        BankTransaction transaction = new BankTransaction("T1", 200);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Process the transaction
        transaction.processTransaction();

        // Restore original System.out
        System.setOut(originalSystemOut);

        // Verify that the expected log messages were printed
        String message1 = "Обробка транзакції T1 : 200.0";
        String message2 = "Транзакція T1 оброблена успішно.";

        assertTrue(outputStream.toString().contains(message1), "Вихідні дані повинні бути: " + message1);
        assertTrue(outputStream.toString().contains(message2), "Вихідні дані повинні бути: " + message2);
    }
}
