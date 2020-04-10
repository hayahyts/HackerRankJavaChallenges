package substring;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        substring(input, start, end);
    }

    static void substring(String input, int start, int end) {
        if (start < end && input.length() >=end) {
            String result = input.substring(start, end);
            System.out.println(result);
        }
    }
}