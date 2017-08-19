public class MergeSort {
    public static void main(String[] args) {
        int myArray[] = {10, 5, 7, 8, 1, 2, 6, 3, 4, 9};
        int temp[] = new int[myArray.length];
        mergeSort(myArray, temp, 0, myArray.length - 1);
        for (int myArrayElement : myArray) {
            System.out.print(myArrayElement + " ");
        }
    }

    private static void mergeSort(int[] myArray, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd)
            return;

        int median = (leftStart + rightEnd) / 2;
        mergeSort(myArray, temp, 0, median);
        mergeSort(myArray, temp, median + 1, rightEnd);
        mergeHalves(myArray, temp, leftStart, rightEnd);
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
