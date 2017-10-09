import java.util.*;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 03 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/TestBed
 */
public class TestBed {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        subsetSums(array, 0, array.length - 1, 0);
    }

    private static void subsetSums(int arr[], int l, int r, int sum) {
        if (l > r) {
            System.out.print(sum + " ");
            return;
        }

        subsetSums(arr, l + 1, r, sum + arr[l]);
        subsetSums(arr, l + 1, r, sum);
    }

}
