package misc;

import static misc.PrintUtils.printArray;

public class SelectionSort {

    public static String[] sort(String[] array, boolean isAscending) {
        int n = array.length;

        // One by one, move the unsorted boundary of unsorted array
        for (int i = 0; i < n - 1; i++) {

            // Find the smallest element in unsorted array
            int minElementIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (isAscending) {
                    if (array[j].compareTo(array[minElementIndex]) < 0) {
                        minElementIndex = j;
                    }
                } else {
                    if (array[j].compareTo(array[minElementIndex]) > 0) {
                        minElementIndex = j;
                    }
                }
            }

            // Move the smallest element to the beginning of the unsorted array
            String temp = array[i];
            array[i] = array[minElementIndex];
            array[minElementIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "d", "b", "c", "e"};
        printArray(arr, "Unsorted array");
        String[] sortedArr = sort(arr, true);
        printArray(sortedArr, "Sorted array");
    }
}