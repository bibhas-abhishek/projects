import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 04 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/QuickSort
 **/

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {7, 4, 5, 8, 1, 2, 0, 9};
        quickSort(A, 0, A.length - 1);
        Arrays.stream(A).mapToObj(element -> element + " ").forEach(System.out::print);
    }

    private static void quickSort(int[] A, int start, int end) {
        if (start < end) {
            int pIndex = partition(A, start, end);
            quickSort(A, start, pIndex - 1);
            quickSort(A, pIndex + 1, end);
        }
    }

    private static int partition(int[] A, int start, int end) {
        int partitionIndex = start;
        int pivot = A[end];
        for (int i = start; i < end; i++) {
            if (A[i] <= pivot) {
                swap(A, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(A, partitionIndex, end);
        return partitionIndex;
    }

    private static void swap(int[] A, int a, int b) {
        int temp = A[b];
        A[b] = A[a];
        A[a] = temp;
    }

}
