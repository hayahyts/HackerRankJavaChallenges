import java.util.HashMap;

class Result {

    private static final int DAYS_IN_YEAR = 365;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int FEB_29 = 29;
    private static final int PREV_DATE = -1;
    private static final int FUTURE_DATE = 1;
    private static int iDayOfMonth = 14;
    private static int iMonth = 8;
    private static int iYear = 2017;
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
    public static int calculateDurationInDays(int dayOfMonth, int month, int year) {
        // Calculate days in full years between start and end year
        int leapDays = calculateLeapDaysWithinDateRange(Math.min(year, iYear), Math.max(year, iYear));
        int daysInFullYears = 0;
        if (year > iYear) {
            daysInFullYears = (year - iYear - 1) * DAYS_IN_YEAR;
        } else if (year < iYear) {
            daysInFullYears = (iYear - year - 1) * DAYS_IN_YEAR;
        }
        daysInFullYears += leapDays;

        // Calculate days in full months in both start and end year
        // Calculate days in start and end months of start and end year respectively
        int startYearFullMonthDays;
        int endYearFullMonthDays;

        int startMonthDays;
        int endMonthDays;

        int totalDays;
        if (year == iYear && month == iMonth && dayOfMonth == iDayOfMonth) {
            totalDays = 0;
        } else if (year == iYear && month == iMonth) {
            totalDays = Math.max(dayOfMonth, iDayOfMonth) - Math.min(dayOfMonth, iDayOfMonth);
            if (dayOfMonth < iDayOfMonth) {
                totalDays *= -1;
            }
        } else if (year == iYear) {
            if (month > iMonth) {
                int fullMonthDays = daysInFullMonthsOfSameYear(iMonth, month);
                startMonthDays = daysInStartMonth(iDayOfMonth, iMonth, iYear);
                endMonthDays = daysInEndMonth(dayOfMonth);
                totalDays = startMonthDays + fullMonthDays + endMonthDays;
            } else {
                int fullMonthDays = daysInFullMonthsOfSameYear(month, iMonth);
                startMonthDays = daysInStartMonth(dayOfMonth, month, year);
                endMonthDays = daysInEndMonth(iDayOfMonth);
                totalDays = startMonthDays + fullMonthDays + endMonthDays;

                totalDays *= -1;
            }
        } else if (getTypeOfDate(dayOfMonth, month, year) == FUTURE_DATE) {
            // Start year is iDayOfMonth, iMonth, iYear
            // End year is dayOfMonth, month, year
            startYearFullMonthDays = daysInFullMonthsOfStartYear(iMonth, iYear);
            endYearFullMonthDays = daysInFullMonthsOfEndYear(month, year);

            startMonthDays = daysInStartMonth(iDayOfMonth, iMonth, iYear);
            endMonthDays = daysInEndMonth(dayOfMonth);

            totalDays = daysInFullYears + startYearFullMonthDays + endYearFullMonthDays + startMonthDays + endMonthDays;
        } else if (getTypeOfDate(dayOfMonth, month, year) == PREV_DATE) {
            // Start year is dayOfMonth, month, year
            // End year is iDayOfMonth, iMonth, iYear
            startYearFullMonthDays = daysInFullMonthsOfStartYear(month, year);
            endYearFullMonthDays = daysInFullMonthsOfEndYear(iMonth, iYear);

            startMonthDays = daysInStartMonth(dayOfMonth, month, year);
            endMonthDays = daysInEndMonth(iDayOfMonth);

            totalDays = daysInFullYears + startYearFullMonthDays + endYearFullMonthDays + startMonthDays + endMonthDays;
            totalDays *= -1;
        } else {
            totalDays = 0;
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

    private static int daysInFullMonthsOfSameYear(int startMonth, int endMonth) {
        int fullMonthDays = 0;
        for (int i = startMonth + 1; i < endMonth; i++) {
            if (i == 2 && isLeapYear(iYear)) {
                fullMonthDays += FEB_29;
            } else {
                fullMonthDays += months.getOrDefault(i, 0);
            }
        }
        return fullMonthDays;
    }

    private static int daysInFullMonthsOfStartYear(int month, int year) {
        int daysInFullMonths = 0;
        for (int i = month + 1; i <= MONTHS_IN_YEAR; i++) {
            if (i == 2 && isLeapYear(year)) {
                daysInFullMonths += FEB_29;
            } else {
                daysInFullMonths += months.getOrDefault(i, 0);
            }
        }
        return daysInFullMonths;
    }

    private static int daysInFullMonthsOfEndYear(int month, int year) {
        int daysInFullMonths = 0;
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeapYear(year)) {
                daysInFullMonths += FEB_29;
            } else {
                daysInFullMonths += months.getOrDefault(i, 0);
            }
        }
        return daysInFullMonths;
    }

    private static int daysInStartMonth(int dayOfMonth, int month, int year) {
        int startMonthDays = 0;

        int daysInThisMonth;
        if (month == 2 && isLeapYear(year)) {
            daysInThisMonth = FEB_29;
        } else {
            daysInThisMonth = months.getOrDefault(month, 0);
        }
        for (int i = dayOfMonth + 1; i <= daysInThisMonth; i++) {
            startMonthDays++;
        }
        return startMonthDays;
    }

    private static int daysInEndMonth(int dayOfMonth) {
        int endMonthDays = 0;
        for (int i = 1; i <= dayOfMonth; i++) {
            endMonthDays++;
        }
        return endMonthDays;
    }

    /**
     * @param dayOfMonth Day of the month
     * @param month      Month of the Year
     * @param year       Year of the Calender
     * @return [FUTURE_DATE] for future date, [PREV_DATE] for previous date and [SAME_DATE] for same date
     */
    private static int getTypeOfDate(int dayOfMonth, int month, int year) {
        if (year > iYear) {
            return FUTURE_DATE;
        } else if (iYear > year) {
            return PREV_DATE;
        } else {
            if (month > iMonth) {
                return FUTURE_DATE;
            } else if (iMonth > month) {
                return PREV_DATE;
            } else {
                return Integer.compare(dayOfMonth, iDayOfMonth);
            }
        }
    }

    private static int calculateLeapDaysWithinDateRange(int startYear, int endYear) {
        int totalLeapYears = 0;
        for (int i = startYear + 1; i <= endYear - 1; i++) {
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

    public static String findDay(int month, int day, int year) {
        int daysDifference = calculateDurationInDays(day, month, year);
        return getDayOfWeek(daysDifference);
    }
}
