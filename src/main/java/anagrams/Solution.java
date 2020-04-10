package anagrams;

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        String sortedA = sortString(a);
        String sortedB = sortString(b);

        return sortedA.equalsIgnoreCase(sortedB);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

    private static String sortString(String str) {
        String sortedString = "";
        for (int i = 0; i < str.length(); i++) {
            String smallestStr = str.substring(i, i + 1);
            for (int j = i; j < str.length(); j++) {
                if (str.substring(j, j + 1).compareToIgnoreCase(smallestStr) < 0) {
                    smallestStr = str.substring(j, j + 1);
                }
            }
            System.out.println(sortedString);
        }

        return sortedString;
    }
}
