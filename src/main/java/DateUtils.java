import java.util.HashMap;

public class DateUtils {
    private static int iDayOfMonth = 14;
    private static int iMonth = 8;
    private static int iYear = 2019;
    private static HashMap<Integer, Integer> months = new HashMap<>();
    private static HashMap<Integer, String> nameOfDays = new HashMap<>();

    static {
        // Initialize months
        months.put(1, 31);   // January
        months.put(2, 28);   // February
        months.put(3, 31);   // March
        months.put(4, 30);   // April
        months.put(5, 31);   // May
        months.put(6, 30);   // June
        months.put(7, 31);   // July
        months.put(8, 31);   // August
        months.put(9, 30);   // September
        months.put(10, 31);  // October
        months.put(11, 30);  // November
        months.put(12, 31);  // December

        // Initialize name of days
        nameOfDays.put(0, "MONDAY");
        nameOfDays.put(1, "TUESDAY");
        nameOfDays.put(2, "WEDNESDAY");
        nameOfDays.put(3, "THURSDAY");
        nameOfDays.put(4, "FRIDAY");
        nameOfDays.put(5, "SATURDAY");
        nameOfDays.put(6, "SUNDAY");
    }

    /**
     * Takes a date an returns the number of days after that date and [14/8/2017]
     *
     * @param dayOfMonth Day of the month
     * @param month      Month of the Year
     * @param year       Year of the Calender
     * @return number of days after [14/8/2017] to given date. Last day inclusive
     */
    public static int calculateDayDifference(int dayOfMonth, int month, int year) {
        // Calculate year difference
        int daysInYearDifference;
        int yearDifference = year - iYear;
        if (yearDifference >= 0) {
            int leapYears = calculateLeapYearsWithinDateRange(iYear, year);
            daysInYearDifference = (yearDifference * 365) + leapYears;
        } else {
            int leapYears = calculateLeapYearsWithinDateRange(year, iYear);
            daysInYearDifference = (yearDifference * 365) - leapYears;
        }

        // Calculate month difference
        int daysInMonthsDifference = 0;
        if (month > iMonth) {
            for (int i = iMonth + 1; i <= month; i++) {
                daysInMonthsDifference += getDaysOfMonth(i);
            }
        } else {
            for (int i = month + 1; i <= iMonth; i++) {
                daysInMonthsDifference -= getDaysOfMonth(i);
            }
        }

        // Calculate day difference
        int daysDifference = dayOfMonth - iDayOfMonth;

        int totalDays = daysInYearDifference + daysInMonthsDifference + daysDifference;

        // If either the start year or end year is a leap year,
        // But the start and end date doesn't include 29th February,
        // Then we need to remove that one leap day added to the [daysInYearDifference]
        if (isStartOrEndYearLeapYearAndFebruary29NotBetweenDates(daysInYearDifference, dayOfMonth, month, year)) {
            totalDays = totalDays + (yearDifference >= 0 ? -1 : 1);
        }

        return totalDays;
    }

    /**
     * Takes number of days after [14/8/2017]
     *
     * @param days If positive, then number of days after else number of days before
     * @return Name of that day. For example, [15/8/2015]
     */
    public static String getDayOfWeek(int days) {
        if (days > 0) {
            int dayNumber = days % 7;
            return nameOfDays.getOrDefault(dayNumber, "UNKNOWN");
        } else {
            int newDay = days + (int) (Math.ceil(Math.abs(days) / 7.0) * 7);
            return nameOfDays.getOrDefault(newDay, "UNKNOWN");
        }
    }

    private static Integer getDaysOfMonth(int i) {
        return months.getOrDefault(i, 0);
    }

    private static boolean isStartOrEndYearLeapYearAndFebruary29NotBetweenDates(int daysDifference, int day, int month, int year) {
        if (isLeapYear(year) || isLeapYear(iYear)) {
            // Start date must be after 29 February of that year
            // End date must be before 29 February of that year
            if (daysDifference < 0) { // start date [day,month] ; end date [iDayOfMonth,iMonth]
                return isAfterOrEqualToFeb29(day, month) || isBeforeFeb29(iDayOfMonth, iMonth);
            } else if (daysDifference > 0) { // start date is the default date [14/8/2017]
                return isAfterOrEqualToFeb29(iDayOfMonth, iMonth) || isBeforeFeb29(day, month);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isAfterOrEqualToFeb29(int day, int month) {
        final int FEBRUARY = 2;
        final int FEB_29 = 29;

        if (month > FEBRUARY) {
            return true;
        } else if (month < FEBRUARY) {
            return false;
        } else { // If the month is Feb, then we compare the days
            if (day >= FEB_29) {
                return true;
            } else {
                return true;
            }
        }
    }

    private static boolean isBeforeFeb29(int day, int month) {
        return !isAfterOrEqualToFeb29(day, month);
    }

    private static int calculateLeapYearsWithinDateRange(int startYear, int endYear) {
        int totalLeapYears = 0;
        for (int i = startYear; i <= endYear; i++) {
            if (isLeapYear(i)) {
                totalLeapYears++;
            }
        }
        return totalLeapYears;
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
