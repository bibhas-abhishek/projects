/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: KthLargestElementArray
*- 18 Nov 2021 1:55 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

public class KthLargestElementArray {

    public int findKthLargest(int[] arr, int k) {
        return findKthSmallestUtil(arr, 0, arr.length - 1, arr.length - k);
    }

    private int findKthSmallestUtil(int[] arr, int start, int end, int k) {
        if (start > end) {
            return -1;
        }

        int pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex += 1;
            }
        }

        swap(arr, pIndex, end);
        if (pIndex == k) {
            return arr[pIndex];
        } else if (k > pIndex) {
            return findKthSmallestUtil(arr, pIndex + 1, end, k); // search right
        } else {
            return findKthSmallestUtil(arr, start, pIndex - 1, k); // search left
        }
    }

    private void swap(int[] A, int a0, int a1) {
        int temp = A[a0];
        A[a0] = A[a1];
        A[a1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 6, 4 };
        KthLargestElementArray driver = new KthLargestElementArray();
        System.out.println(driver.findKthLargest(arr, 2));
    }
}
