/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 22 Apr 2018
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/IncreasingTriplet
 **/

public class IncreasingTriplet {

    private static boolean increasingTriplet(int[] nums) {
        int firstSmall = Integer.MAX_VALUE, secondSmall = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < firstSmall)
                firstSmall = i;
            else if (i < secondSmall)
                secondSmall = i;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 2, 0};
        System.out.println(increasingTriplet(nums));
    }

}
