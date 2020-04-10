package currency_formatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        formatCurrency(payment);
    }

    public static void formatCurrency(double payment) {
        // Get the locales for each country
        Locale usLocale = Locale.US;
        Locale indiaLocale = new Locale("en", "IN");
        Locale chinaLocale = Locale.CHINA;
        Locale franceLocale = Locale.FRANCE;

        // Create a number formatter
        NumberFormat usFormatter = NumberFormat.getCurrencyInstance(usLocale);
        NumberFormat indiaFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat chinaFormatter = NumberFormat.getCurrencyInstance(chinaLocale);
        NumberFormat franceFormatter = NumberFormat.getCurrencyInstance(franceLocale);

        // Format into different currencies
        System.out.println("US: " + usFormatter.format(payment));
        System.out.println("India: " + indiaFormatter.format(payment));
        System.out.println("China: " + chinaFormatter.format(payment));
        System.out.println("France: " + franceFormatter.format(payment));
    }
}