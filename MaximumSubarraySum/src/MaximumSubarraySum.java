import java.util.Arrays;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 05 Apr 2018
 * https://www.hackerrank.com/challenges/maxsubarray/problem
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumSubarraySum
 **/

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int array[] = {-1, -2, -3, -4, -5, -6};
        for (int i : maxSubarray(array)) {
            System.out.print(i + " ");
        }
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

    private static int[] maxSubarray(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        if (max < 0)
            return new int[]{max, max};

        int maxSubarraySumHere = 0, maxSubsequenceSumHere = 0,
                maxSubarraySum = 0, maxSubsequenceSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                maxSubsequenceSumHere += array[i];
                maxSubsequenceSumHere = Math.max(0, maxSubsequenceSumHere);
            }

            maxSubarraySumHere += array[i];
            maxSubarraySumHere = Math.max(0, maxSubarraySumHere);
            maxSubarraySum = Math.max(maxSubarraySum, maxSubarraySumHere);
            maxSubsequenceSum = Math.max(maxSubsequenceSum, maxSubsequenceSumHere);
        }
        return new int[]{maxSubarraySum, maxSubsequenceSum};
    }

}
