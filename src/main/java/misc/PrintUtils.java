package misc;

public class PrintUtils {
    public static void printArray(String[] arr, String heading) {
        System.out.println(heading + "\n-------------");
        for (String element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("\n");
    }
}
