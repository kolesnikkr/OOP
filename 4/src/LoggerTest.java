import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LoggerTest {

    @org.junit.Test
    @Test
    public void testLoggerSingleton() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both logger instances are the same
        assertSame(logger1, logger2, "Logged має бути єдиним.");
    }

    @Test
    public void testLogMessage() {
        Logger logger = Logger.getInstance();

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        logger.log("Тестове повідомлення");

        System.setOut(originalSystemOut);

        String expectedMessage = "LOG: Тестове повідомлення";
        assertTrue(outputStream.toString().contains(expectedMessage),
                "Logged має містити:: " + expectedMessage);
    }
}


