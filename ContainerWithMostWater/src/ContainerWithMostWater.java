/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 27 May 2018
 * https://leetcode.com/problems/container-with-most-water/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/ContainerWithMostWater
 **/

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l += 1;
            else
                r += 1;
        }
        return maxArea;
    }

}
