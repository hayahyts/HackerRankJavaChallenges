package string_reverse;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.equals(reverseString(str))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static String reverseString(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i > -1; i--) {
            reversedString = reversedString + "" + str.charAt(i);
        }

        return reversedString;
    }
}
