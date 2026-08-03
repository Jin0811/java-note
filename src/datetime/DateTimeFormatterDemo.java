package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatted = now.format(formatter);
        LocalDateTime parsed = LocalDateTime.parse("2026-08-03 14:30:00", formatter);

        System.out.println("formatted = " + formatted);
        System.out.println("parsed = " + parsed);
    }
}

