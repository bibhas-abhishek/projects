import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 09 Apr 2018
 * https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * https://leetcode.com/problems/sort-colors/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/DutchNationalFlagProblem
 **/

public class DutchNationalFlagProblem {

    public int[] dutchNationalFlagSort(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;
        while (mid <= high) {
            if (array[mid] == 0) {
                swap(array, low, mid);
                mid += 1;
                low += 1;
            }
            else if (array[mid] == 1)
                mid += 1;
            else if (array[mid] == 2) {
                swap(array, mid, high);
                high -= 1;
            }
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        if (array[a] != array[b]) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    public static void main(String[] args) {
        DutchNationalFlagProblem obj = new DutchNationalFlagProblem();
        int[] array = { 0, 1, 2, 0, 2, 1, 2, 1, 2, 1, 0 };
        array = obj.dutchNationalFlagSort(array);
        Arrays.stream(array).mapToObj(i -> i + " ").forEach(System.out::print);
    }
}
