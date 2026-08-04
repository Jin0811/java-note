package quiz.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Quiz03DurationPeriodQuestion {
    public static void main(String[] args) {
        Period period = Period.between(
                LocalDate.of(2026, 8, 1),
                LocalDate.of(2026, 8, 10)
        );

        Duration duration = Duration.between(
                LocalDateTime.of(2026, 8, 4, 10, 0),
                LocalDateTime.of(2026, 8, 4, 12, 30)
        );

        System.out.println(period.getDays());
        System.out.println(duration.toMinutes());

        /*
         * 问题：
         * 1. period.getDays() 输出多少？
         * 2. duration.toMinutes() 输出多少？
         * 3. Period 和 Duration 分别适合什么场景？
         */
    }
}
