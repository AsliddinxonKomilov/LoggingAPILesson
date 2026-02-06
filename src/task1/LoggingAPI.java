package task1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingAPI {
    public static Logger logger = Logger.getLogger("TODO App");
    public static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("loggingApi/task1uchun.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.info("Dastur normal ishlamoqda");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
