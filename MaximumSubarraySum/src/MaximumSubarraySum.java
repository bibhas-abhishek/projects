import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 05 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/MaximumSubarraySum
 **/

public class MaximumSubarraySum {

    public int maximumSubarraySum(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        if (max < 0) {
            return max;
        }

        int sum = 0, maxSum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            sum = Math.max(0, sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] array = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(new MaximumSubarraySum().maximumSubarraySum(array));
    }
}
