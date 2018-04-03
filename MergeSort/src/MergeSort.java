import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeSort
 */
public class MergeSort {

    public static void main(String[] args) {
        int array[] = {10, 5, 7, 8, 1, 2, 6, 3, 4, 9};
        int temp[] = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
        Arrays.stream(array).mapToObj(myArrayElement -> myArrayElement + " ").forEach(System.out::print);
    }

    private static void mergeSort(int[] array, int[] temp, int start, int end) {
        if (end <= start)
            return;

        int mid = (start + end) / 2;
        mergeSort(array, temp, start, mid);
        mergeSort(array, temp, mid + 1, end);
        merge(array, temp, start, end);
    }

    private static void merge(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int l = leftStart;
        int r = rightStart;
        int index = leftStart;

        while (l <= leftEnd && r <= rightEnd) {
            if (array[l] <= array[r])
                temp[index++] = array[l++];
            else
                temp[index++] = array[r++];
        }

        System.arraycopy(array, l, temp, index, leftEnd - l + 1); // copy remaining left array elements
        System.arraycopy(array, r, temp, index, rightEnd - r + 1); // copy remaining right array elements
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd - leftStart + 1); // copy temp back to main array
    }

}
