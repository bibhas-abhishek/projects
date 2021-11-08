/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: QuickSort
*- 08 Nov 2021 6:49 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/sort-an-array/submissions/
-------------------------------------------*/

public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pIndex = start;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex += 1;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 5, 8, 1, 2, 0, 9 };
        QuickSort driver = new QuickSort();
        driver.quickSort(arr, 0, arr.length - 1);
        for (int c : arr) {
            System.out.print(c + " ");
        }
    }
}
