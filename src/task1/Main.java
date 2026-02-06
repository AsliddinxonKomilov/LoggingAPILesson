package task1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vazifa nomini kiriting : ");
        scanner.nextLine();

        System.out.println("Vaqtni kiriting (yyyy-MM-dd HH:mm:ss) formatida : ");
        String waitingTime = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(waitingTime,formatter);

        try {
            LoggingAPI.logger.info("Vaqt muvaffaqiyatli kiritildi : " + waitingTime);
        } catch (Exception e){
            LoggingAPI.logger.warning("Vaqt kiritishda muammo yuz berdi!");
            return;
        }
        long kutish = ChronoUnit.SECONDS.between(LocalDateTime.now(),localDateTime);
        if (kutish <= 0){
            LoggingAPI.logger.warning("Kechirasiz vaqt tugagan!");
        } else {
            LoggingAPI.logger.info("Eslatma : " + kutish + " dan keyin chiqadi!");
        }
        new Thread(() ->{
            try {
                Thread.sleep(kutish * 1000);
                LoggingAPI.logger.warning("VAQT KELDIII!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}

