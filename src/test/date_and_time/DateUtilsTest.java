package date_and_time;

import org.junit.jupiter.api.Test;

class DateUtilsTest {

    @Test
    void giveSameDate_whenCalculateDaysCalled_returnZero() {
        // Test same day
        int totalDays = DateUtils.calculateDurationInDays(14, 8, 2017);
        assert (totalDays == 0);
    }

    @Test
    void givenFutureYear_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Year
        int totalDays3 = DateUtils.calculateDurationInDays(14, 9, 2018);
        assert (totalDays3 == 396);
    }

    @Test
    void givenFutureLeapYear_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Year
        int totalDays3 = DateUtils.calculateDurationInDays(14, 8, 2020);
        assert (totalDays3 == 1096);
    }

    @Test
    void givenFutureDay_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Day
        int totalDays1 = DateUtils.calculateDurationInDays(15, 8, 2017);
        assert (totalDays1 == 1);
    }

    @Test
    void givenFutureMonth_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Month
        int totalDays2 = DateUtils.calculateDurationInDays(14, 9, 2017);
        assert (totalDays2 == 31);
    }

    @Test
    void givenFutureDayAndMonth_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Day and Month
        int totalDays4 = DateUtils.calculateDurationInDays(15, 9, 2017);
        assert (totalDays4 == 32);
    }

    @Test
    void givenFutureMonthAndYear_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Month and Year
        int totalDays5 = DateUtils.calculateDurationInDays(14, 9, 2018);
        assert (totalDays5 == 396);
    }

    @Test
    void givenFutureDate_whenCalculateDaysCalled_returnPositiveDays() {
        // Test Day, Month and Year
        int totalDays6 = DateUtils.calculateDurationInDays(7, 4, 2021);
        assert (totalDays6 == 1332);
    }

    @Test
    void givenPrevDay_whenCalculateDaysCalled_returnNegativeDays() {
        // Test Day
        int totalDays1 = DateUtils.calculateDurationInDays(12, 8, 2017);
        assert (totalDays1 == -2);
    }

    @Test
    void givenPrevMonth_whenCalculateDaysCalled_returnNegativeDays() {
        // Test Month
        int totalDays2 = DateUtils.calculateDurationInDays(14, 7, 2017);
        assert (totalDays2 == -31);
    }

    @Test
    void givenPrevYear_whenCalculateDaysCalled_returnNegativeDays() {
        // Test Year
        int totalDays3 = DateUtils.calculateDurationInDays(1, 3, 2016);
        assert (totalDays3 == -531);
    }

    @Test
    void givenPrevDayAndMonth_whenCalculateDaysCalled_returnNegativeDays() {
        // Test Day and Month
        int totalDays = DateUtils.calculateDurationInDays(15, 7, 2017);
        assert (totalDays == -30);
    }

    @Test
    void givenPrevMonthAndYear_whenCalculateDaysCalled_returnNegativeDays() {
        // Test Day and Month
        int totalDays = DateUtils.calculateDurationInDays(14, 7, 2016);
        assert (totalDays == -396);
    }

    @Test
    void givenPrevDate_whenCalculateDaysCalled_returnNegativeDays() {
        // Test Day and Month
        int totalDays = DateUtils.calculateDurationInDays(13, 7, 2016);
        assert (totalDays == -397);
    }

    @Test
    void givenPositiveDays_whenGetDayOfWeekCalled_returnRightName() {
        String dayName0 = DateUtils.getDayOfWeek(0);
        assert (dayName0.equals("MONDAY"));

        String dayName1 = DateUtils.getDayOfWeek(1);
        assert (dayName1.equals("TUESDAY"));

        String dayName3 = DateUtils.getDayOfWeek(967);
        assert (dayName3.equals("TUESDAY"));
    }

    @Test
    void givenNegativeDays_whenGetDayOfWeekCalled_returnRightName() {
        String dayName0 = DateUtils.getDayOfWeek(-1);
        assert (dayName0.equals("SUNDAY"));

        String dayName1 = DateUtils.getDayOfWeek(-2);
        assert (dayName1.equals("SATURDAY"));

        String dayName2 = DateUtils.getDayOfWeek(-8);
        assert (dayName2.equals("SUNDAY"));
    }
}