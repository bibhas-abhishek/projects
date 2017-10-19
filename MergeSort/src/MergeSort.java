import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 16 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeSort
 */
public class MergeSort {

    public static void main(String[] args) {
        int myArray[] = {10, 5, 7, 8, 1, 2, 6, 3, 4, 9};
        int temp[] = new int[myArray.length];
        mergeSort(myArray, temp, 0, myArray.length - 1);
        Arrays.stream(myArray).mapToObj(myArrayElement -> myArrayElement + " ").forEach(System.out::print);
    }

    private static void mergeSort(int[] myArray, int[] temp, int start, int end) {
        if (start >= end)
            return;

        int median = (start + end) / 2;
        mergeSort(myArray, temp, 0, median);
        mergeSort(myArray, temp, median + 1, end);
        mergeHalves(myArray, temp, start, end);
    }

    private static void mergeHalves(int[] myArray, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (myArray[left] <= myArray[right])
                temp[index++] = myArray[left++];
            else
                temp[index++] = myArray[right++];

        }

        System.arraycopy(myArray, left, temp, index, leftEnd - left + 1);
        System.arraycopy(myArray, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, myArray, leftStart, rightEnd - leftStart + 1);
    }

}
