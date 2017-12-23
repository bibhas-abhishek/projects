/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 24 Dec 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/MergeSortedArray/
 * https://leetcode.com/problems/merge-sorted-array/description/
 **/

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 5, 0, 0, 0};
        int[] array2 = new int[]{2, 4, 6};
        merge(array1, 3, array2, 3);
    }

    private static void merge(int[] array1, int m, int[] array2, int n) {
        int j = m - 1;
        int k = n - 1;
        int i = m + n - 1;
        for (; i > 0 && j >= 0 && k >= 0; ) {
            if (array1[j] >= array2[k])
                array1[i--] = array1[j--];
            else
                array1[i--] = array2[k--];
        }

        while (i >= 0 && k >= 0) {
            array1[i--] = array2[k--];
        }

        for (i = 0; i < array1.length; i++)
            System.out.print(array1[i] + " ");
    }

}
