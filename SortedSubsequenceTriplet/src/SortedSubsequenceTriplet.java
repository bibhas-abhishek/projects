/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Sep 2018
 * https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 * https://github.com/bibhas-abhishek/projects/tree/master/SortedSubsequenceTriplet
 */

public class SortedSubsequenceTriplet {

    private static void findOrderedTriplets(int[] arr) {
        int n = arr.length;
        int min = 0;
        int max = n - 1;
        int[] smaller = new int[n];
        int[] larger = new int[n];
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[min] < arr[i])
                smaller[i] = min;
            else {
                smaller[i] = -1;
                min = i;
            }
        }

        larger[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[max] > arr[i])
                larger[i] = max;
            else {
                larger[i] = -1;
                max = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && larger[i] != -1) {
                System.out.println(arr[smaller[i]] + " " + arr[i] + " " + arr[larger[i]]);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 10, 5, 6, 2, 30};
        findOrderedTriplets(arr);
    }

}
