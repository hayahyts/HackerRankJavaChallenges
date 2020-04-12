package regex;

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches((new MyRegex().pattern)));
        }
    }

    @SuppressWarnings("unused")
    private static boolean btw0To255(String num) {
        return num.matches("([0-9]|[0-9][0-9]|[01][0-9][0-9]|[02][0-4][0-9]|25[0-5])");
    }
}


//Write your code here
