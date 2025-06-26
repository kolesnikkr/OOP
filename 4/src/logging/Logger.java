package logging;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private final List<String> logs = new ArrayList<>();

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        logs.add(message);
        System.out.println("LOG: " + message);
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs);
    }
    public void clear() {
        logs.clear();
    }
}
