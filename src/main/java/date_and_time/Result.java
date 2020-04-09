package date_and_time;

import static date_and_time.DateUtils.calculateDurationInDays;
import static date_and_time.DateUtils.getDayOfWeek;

public class Result {

    public static String findDay(int month, int day, int year) {
        int daysDifference = calculateDurationInDays(day, month, year);
        return getDayOfWeek(daysDifference);
    }
}
