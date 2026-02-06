package self;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("ChatApp");

        FileHandler fileHandler = new FileHandler("task1uchun.txt",true);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        logger.info("User 'asliddin@gmail.com' muvaffaqiyatli royxatdan otdi");
    }
}