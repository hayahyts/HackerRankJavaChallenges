package substring;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static substring.Solution.substring;

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
    void givenString_whenSubstringCalled_printSubstring() {
        String input = "Helloworld";

        substring(input, 3, 7);

        String expected = "lowo\r\n";
        String actual = outContent.toString();

        assertEquals(expected, actual);
    }
}