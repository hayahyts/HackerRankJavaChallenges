package string_tokens;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    void givenString_whenTokenizeCalled_printTokensToScreen() {
        String input = "He is a very very good boy, isn't he?";

        String expectedOutput = "10\r\n" +
                "He\r\n" +
                "is\r\n" +
                "a\r\n" +
                "very\r\n" +
                "very\r\n" +
                "good\r\n" +
                "boy\r\n" +
                "isn\r\n" +
                "t\r\n" +
                "he\r\n";

        Solution.tokenize(input);

        String actualOutput = outContent.toString();
        assertEquals(expectedOutput, actualOutput);
    }
}