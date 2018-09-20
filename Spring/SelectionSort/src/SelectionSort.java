import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/SelectionSort
 */

public class SelectionSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int findMin(int[] arr, int i, int j) {
        int minIndex = i;
        for (int k = i + 1; k < j; k++) {
            if (arr[k] < arr[minIndex])
                minIndex = k;
        }
        return minIndex;
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length, k;
        for (int i = 0; i < n; i++) {
            k = findMin(arr, i, n);
            if (i != k)
                swap(arr, i, k);
        }
    }

    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        selectionSort(arr);
        Arrays.stream(arr).mapToObj(x -> x + " ").forEach(System.out::print);
    }

}
