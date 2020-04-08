import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void givenOneDayAfter_whenFindDayCalled_returnThursday() {
        String day = Result.findDay(8,15,2017);
        assert(day.equals("THURSDAY"));
    }
}