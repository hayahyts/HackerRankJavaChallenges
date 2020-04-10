package string_tokens;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        tokenize(s);
        scan.close();
    }

    static void tokenize(String input) {
        String[] tokens = input.split("[ !,?._'@]+");
        System.out.println(tokens.length);
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}

/*
    Regex Info
    ----------
    .       - Any character Except a New Line
    \d      - Digit(0-9)
    \D      - Not a Digit(0-9)
    \w      - Word Character (a-z, A-Z, 0-9, _)
    \W      - Not a Word Character
    \s      - Space (space, tab, new line)
    \S      - Not a Space

    \b      - Word boundary
    \B      - Not a Word boundary
    ^       - Beginning of a String
    $       - End of a String

    []      - Matches characters in in brackets
    [^ ]    - Matches characters NOT in the brackets
    |       - Either or
    ()      - Group

    Quantifiers
    *       - 0 or more
    +       - 1 or more
    ?       - 0 or 1
    {3}     - Exact number NB: 3 is just an example
    {3,4}   - Range of numbers (minimum, maximum)

    Examples
    --------
    .@.\.\w{3}
 */
