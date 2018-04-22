/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Apr 2018
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/LongestContinuousIncreasingSubsequence
 **/

public class LongestContinuousIncreasingSubsequence {

    private static int findLengthOfLCIS(int[] array) {
        if (array.length == 1)
            return 1;

        int anchor = 0, result = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] >= array[i])
                anchor = i;
            result = Math.max(result, i - anchor + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] array = {1, 3, 5, 2, 7, 8, 9};
        int[] array = {2, 2, 2, 2};
        System.out.println(findLengthOfLCIS(array));
    }

}
