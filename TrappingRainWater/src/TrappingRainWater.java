/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 17 Sep 2018
 * https://leetcode.com/problems/trapping-rain-water/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/TrappingRainWater
 */

public class TrappingRainWater {

    private static int trap(int[] height) {
        int n = height.length;
        if (n == 0 || n == 1)
            return 0;

        int[] leftMaxes = new int[n];
        int[] rightMaxes = new int[n];
        int result = 0;
        int leftMax = height[0];
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxes[i] = leftMax;
        }

        int rightMax = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMaxes[i] = rightMax;
            int minLeftRightDiff = Math.min(leftMaxes[i], rightMaxes[i]);
            if (minLeftRightDiff > height[i])
                result += minLeftRightDiff - height[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(arr));
    }

}
