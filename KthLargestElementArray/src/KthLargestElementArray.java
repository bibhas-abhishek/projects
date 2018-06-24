/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 18 Apr 2018
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/KthLargestElementArray
 * Quick Select Algorithm
 **/

public class KthLargestElementArray {

    private static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int findKthLargest(int[] A, int start, int end, int k) {
        if (start > end)
            return -1;

        int pivot = A[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (A[i] <= pivot) {
                swap(A, i, pIndex);
                pIndex += 1;
            }
        }
        swap(A, pIndex, end);

        if (pIndex == k)
            return A[pIndex];
        else if (k > pIndex)
            return findKthLargest(A, pIndex + 1, end, k);
        else
            return findKthLargest(A, start, pIndex - 1, k);
    }

    private static void swap(int[] A, int a0, int a1) {
        int temp = A[a0];
        A[a0] = A[a1];
        A[a1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }

}
