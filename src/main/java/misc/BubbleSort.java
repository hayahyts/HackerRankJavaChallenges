package misc;

import static misc.PrintUtils.printArray;

public class BubbleSort {
    public static String[] sort(String[] array, boolean isAscending) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (isAscending) {
                    if (array[j].compareTo(array[j + 1]) > 0) {
                        String temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                } else {
                    if (array[j].compareTo(array[j + 1]) < 0) {
                        String temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "d", "b", "c", "e"};
        printArray(arr, "Unsorted array");
        String[] sortedArr = sort(arr, false);
        printArray(sortedArr, "Sorted array");
    }
}
