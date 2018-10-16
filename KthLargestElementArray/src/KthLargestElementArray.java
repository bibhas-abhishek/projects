/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Apr 2018
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/KthLargestElementArray
 * Quick Select Algorithm
 **/

public class KthLargestElementArray {

    public int findKthLargest(int[] arr, int k) {
        return findKthLargestUtil(arr, 0, arr.length - 1, arr.length - k);
    }

    private int findKthLargestUtil(int[] arr, int start, int end, int k) {
        if (start > end)
            return -1;

        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex += 1;
            }
        }

        swap(arr, pIndex, end);
        if (pIndex == k)
            return arr[pIndex];
        else if (k > pIndex)
            return findKthLargestUtil(arr, pIndex + 1, end, k);
        else
            return findKthLargestUtil(arr, start, pIndex - 1, k);
    }

    private void swap(int[] A, int a0, int a1) {
        int temp = A[a0];
        A[a0] = A[a1];
        A[a1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        KthLargestElementArray obj = new KthLargestElementArray();
        System.out.println(obj.findKthLargest(arr, 2));
    }

}
