/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: DutchNationalFlagProblem
*- 16 Nov 2021 12:54 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
* https://leetcode.com/problems/sort-colors/description/
-------------------------------------------*/

public class DutchNationalFlagProblem {

    public int[] dutchNationalFlagSort(int[] array) {
        int low = 0, mid = 0, high = array.length - 1;
        while (mid <= high) {
            if (array[mid] == 0) {
                swap(array, low, mid);
                mid += 1;
                low += 1;
            } else if (array[mid] == 1) {
                mid += 1;
            } else if (array[mid] == 2) {
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
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
