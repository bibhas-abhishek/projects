import java.util.Arrays;

public class MergeSortedArray {

    private static void merge(int[] array1, int m, int[] array2, int n) {
        int j = m - 1;
        int k = n - 1;
        int i = m + n - 1;
        while (i > 0 && j >= 0 && k >= 0) {
            if (array1[j] >= array2[k]) {
                array1[i--] = array1[j--];
            }
            else {
                array1[i--] = array2[k--];
            }
        }

        // if array1 is exhausted, copy remaining elements of array2 to array1
        while (i >= 0 && k >= 0) {
            array1[i--] = array2[k--];
        }
        System.out.println(Arrays.toString(array1));
    }

    public static void main(String[] args) {
        int[] array1 = new int[] { 3, 5, 7, 0, 0, 0, 0 };
        int[] array2 = new int[] { 1, 2, 4, 6 };
        merge(array1, array1.length - array2.length, array2, array2.length);
    }
}
