package misc;

import static misc.PrintUtils.printArray;

public class InsertionSort {

    public static String[] sort(String[] arr, boolean isAscending) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            String key = arr[i]; // Element to be compared
            int j = i - 1; // Index of first element to be compared

            // While we've not reached start of list,
            // and the key is still less than the element at j
            // we keep pushing the elements to the right
            while (j >= 0 && key.compareTo(arr[j]) < 0) {

                String temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }

            printArray(arr, "Pass " + i);
        }

        return arr;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "d", "b", "c", "e"};
        //printArray(arr, "Unsorted array");
        String[] sortedArr = sort(arr, false);
        printArray(sortedArr, "Sorted array");
    }
}
