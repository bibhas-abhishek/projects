import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 05 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumSubarraySum
 **/

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int array[] = {2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print("Maximum Subarray Sum: " + maximumSubarraySum(array));
    }

    private static int maximumSubarraySum(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        if (max < 0)
            return max;

        int maxSumHere = 0, maxSumSoFar = 0;
        for (int i = 0; i < array.length; i++) {
            maxSumHere += array[i];
            maxSumHere = Math.max(0, maxSumHere);
            maxSumSoFar = Math.max(maxSumSoFar, maxSumHere);
        }
        return maxSumSoFar;
    }

}
