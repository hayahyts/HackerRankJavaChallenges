package currency_formatter;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static currency_formatter.Solution.formatCurrency;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void givenNumber_whenFormatCurrencyCalled_writeFormattedTextToConsole() {
        int input = 5;
        formatCurrency(input);
        String expectedOutput = "US: $5.00\r\n" +
                "India: Rs.5.00\r\n" +
                "China: ￥5.00\r\n" +
                "France: 5,00 €\r\n";
        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, outContent.toString());
    }
}