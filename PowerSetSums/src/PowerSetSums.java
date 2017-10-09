/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 09 Oct 2017
 * https://github.com/bibhas-abhishek/projects/tree/master/PowerSetSums
 * Find sum of all subsets of a set
 */
public class PowerSetSums {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        subsetSums(array, 0, array.length - 1, 0);
    }

    private static void subsetSums(int arr[], int l, int r, int sum) {
        if (l > r) {
            System.out.print(sum + " ");
            return;
        }

        //include arr[l]
        subsetSums(arr, l + 1, r, sum + arr[l]);

        //exclude arr[l]
        subsetSums(arr, l + 1, r, sum);
    }

}
