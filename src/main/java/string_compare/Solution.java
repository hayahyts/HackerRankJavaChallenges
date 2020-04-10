package string_compare;

import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int tokenLen) {
        // Tokenize the string
        String[] tokens = getTokens(s, tokenLen);

        // Sort the tokens
        String[] sortedTokens = sortTokens(tokens);

        String smallest = sortedTokens[0];
        String largest = sortedTokens[sortedTokens.length - 1];
        return smallest + "\n" + largest;
    }

    private static String[] sortTokens(String[] tokens) {
        // Bubble sort
        for (int i = 0; i < tokens.length; i++) {
            // Pick a word and run through the rest to find it's permanent location
            for (int j = 1; j < tokens.length; j++) {
                if (tokens[j - 1].compareTo(tokens[j]) > 0) {
                    String temp = tokens[j - 1];
                    tokens[j - 1] = tokens[j];
                    tokens[j] = temp;
                }
            }
        }

        // Sorted tokens
        /*System.out.print("\n\nSorted tokens\n");
        for (String token : tokens) {
            System.out.print(token + " ");
        }*/

        return tokens;
    }

    private static String[] getTokens(String s, int tokenLen) {
        int strLen = s.length();

        int start = 0;
        int end = tokenLen;

        int totalTokens = strLen - tokenLen + 1;
        String[] tokens = new String[totalTokens];

        while (end <= strLen) {
            String curSubstring = s.substring(start, end);
            tokens[start] = curSubstring;
            start++;
            end++;
        }

        // Print tokens
        /*System.out.println("Tokens");
        for (String token : tokens) {
            System.out.print(token + " ");
        }*/

        return tokens;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String s = "welcometojava";
        scan.close();
        System.out.println(getSmallestAndLargest(s.trim(), k));
    }
}