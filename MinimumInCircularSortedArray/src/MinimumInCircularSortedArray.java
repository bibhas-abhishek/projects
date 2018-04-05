/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 02 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MinimumInCircularSortedArray
 **/

public class MinimumInCircularSortedArray {

    public static void main(String[] args) {
        int array[] = {4, 5, 6, 7, 1, 2, 3};
        System.out.print(findMin(array));
    }

    private static int findMin(int[] array) {
        return findMinHelper(array, array.length, 0, array.length - 1);
    }

    private static int findMinHelper(int[] array, int n, int l, int r) {
        while (l <= r) {
            if (array[l] <= array[r])
                return l;

            int mid = (l + r) / 2;
            int midNext = (mid + 1) % n;
            int midPrev = (mid - 1 + n) % n;
            if (array[mid] <= array[midPrev] && array[mid] <= array[midNext])
                return mid;
            else if (array[l] <= array[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

}
