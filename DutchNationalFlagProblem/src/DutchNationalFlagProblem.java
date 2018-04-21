/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 09 Apr 2018
 * https://leetcode.com/problems/sort-colors/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/DutchNationalFlagProblem
 **/

public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 2, 2, 1, 0, 1, 2, 1, 0};
        array = dutchNationalFlagSort(array);
        for (int i : array)
            System.out.print(i + " ");
    }

    private static int[] dutchNationalFlagSort(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;
        while (mid <= high) {
            if (array[mid] == 0) {
                swap(array, low, mid);
                mid += 1;
                low += 1;
            } else if (array[mid] == 1)
                mid += 1;
            else if (array[mid] == 2) {
                swap(array, mid, high);
                high -= 1;
            }
        }
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        if (array[a] != array[b]) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

}
