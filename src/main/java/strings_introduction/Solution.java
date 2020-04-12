package strings_introduction;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        /* Enter your code here. Print output to STDOUT. */

        int sum = str1.length() + str2.length();
        String capitalizedString = str1.substring(0, 1).toUpperCase() + str1.substring(1) + " " + str2.substring(0, 1).toUpperCase() + str2.substring(1);
        System.out.println(sum);
        System.out.println((str1.compareTo(str2) > 0) ? "Yes" : "No");
        System.out.println(capitalizedString);
    }
}

