package anagrams;

import misc.PrintUtils;

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        String sortedA = sortString(a);
        String sortedB = sortString(b);

        return sortedA.equalsIgnoreCase(sortedB);
    }

    private static String sortString(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;

        // Bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((arr[j] + "").compareToIgnoreCase((arr[j + 1] + "")) > 0) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return String.copyValueOf(arr);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
