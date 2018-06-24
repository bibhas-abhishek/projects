import java.util.Arrays;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 22 Jun 2018
 * https://leetcode.com/problems/array-partition-i/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ArrayPartitionI
 **/

public class ArrayPartitionI {

    private static int arrayPairSum(int[] nums) {
        if (nums.length == 0)
            return -1;

        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2)
            result += nums[i];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

}
