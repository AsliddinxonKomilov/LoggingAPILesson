import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingAPI {
    public static Logger logger = Logger.getLogger("ChatApp");
    public static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("filehandler/filehandler.txt",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        logger.info("Bu ma'lumot berish uchun kerak!");
        logger.warning("Diqqat men xavfdan ogohlantiraman!");
        fileHandler.flush();
        fileHandler.close();
    }
}