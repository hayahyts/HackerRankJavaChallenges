package date_and_time;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void givenOneDayAfter_whenFindDayCalled_returnThursday() {
        String day = Result.findDay(8, 15, 2017);
        assert (day.equals("THURSDAY"));
    }
}