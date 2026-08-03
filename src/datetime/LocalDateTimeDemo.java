package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime now = LocalDateTime.now();

        System.out.println("today = " + today);
        System.out.println("nowTime = " + nowTime);
        System.out.println("now = " + now);

        LocalDate birthday = LocalDate.of(1998, 5, 20);
        System.out.println("birthday = " + birthday);
    }
}

