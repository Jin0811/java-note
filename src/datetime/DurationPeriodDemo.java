package datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class DurationPeriodDemo {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2026, 8, 1);
        LocalDate endDate = LocalDate.of(2026, 8, 10);
        Period period = Period.between(startDate, endDate);

        System.out.println("days = " + period.getDays());

        LocalDateTime startTime = LocalDateTime.of(2026, 8, 3, 10, 0);
        LocalDateTime endTime = LocalDateTime.of(2026, 8, 3, 12, 30);
        Duration duration = Duration.between(startTime, endTime);

        System.out.println("minutes = " + duration.toMinutes());
    }
}

