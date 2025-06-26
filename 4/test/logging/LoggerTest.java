package logging;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest {

    @Test
    public void testLogger() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        assertSame(logger1, logger2, "Logger повинен бути однаковий");
    }

    @Test
    public void testLogger2() {
        Logger logger = Logger.getInstance();
        logger.clear();
        logger.log("Тестове повідомлення");
        assertEquals(1, logger.getLogs().size(), "Logger повинно бути 1");
        assertEquals("Тестове повідомлення", logger.getLogs().get(0));
    }
}