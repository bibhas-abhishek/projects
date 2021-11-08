/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: BoxStacking
*- 06 Nov 2021 1:14 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
* https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
-------------------------------------------*/

import java.util.Arrays;

public class BoxStacking {

    private static class Box {

        int h;
        int l;
        int w;

        public Box(int h, int l, int w) {
            this.h = h;
            this.l = l;
            this.w = w;
        }
    }

    private void createBoxPermutations(Box[] input, Box[] boxPerm) {
        for (int i = 0; i < input.length; i++) {
            boxPerm[3 * i] = new Box(input[i].h, Math.max(input[i].w, input[i].l),
                Math.min(input[i].w, input[i].l));
            boxPerm[3 * i + 1] = new Box(input[i].l, Math.max(input[i].h, input[i].w),
                Math.min(input[i].h, input[i].w));
            boxPerm[3 * i + 2] = new Box(input[i].w, Math.max(input[i].l, input[i].h),
                Math.min(input[i].l, input[i].h));
        }
    }

    public int maxHeight(Box[] input) {
        Box[] boxPerm = new Box[input.length * 3];
        createBoxPermutations(input, boxPerm);
        int maxHeight = 0;
        Arrays.sort(boxPerm, (o1, o2) -> o2.l * o2.w - o1.l * o1.w); // sort in descending order
        int[] dp = new int[boxPerm.length];
        dp[0] = boxPerm[0].h;
        for (int i = 1; i < boxPerm.length; i++) {
            dp[i] = boxPerm[i].h;
            for (int j = 0; j < i; j++) { // check if i can be placed on top of j; since input is sorted in descending order
                if (boxPerm[i].l < boxPerm[j].l && boxPerm[i].w < boxPerm[j].w) {
                    dp[i] = Math.max(dp[i], dp[j] + boxPerm[i].h); // max height at j + height of boxPerm[j]
                }
                maxHeight = Math.max(maxHeight, dp[i]);
            }
        }
        return maxHeight;
    }

    public int maxHeightLC(int[][] A) {
        for (int[] a : A) {
            Arrays.sort(a);
        }

        Arrays.sort(A, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            } else
                return o2[2] - o1[2];
        });
        int n = A.length, res = Integer.MIN_VALUE, dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = A[i][2];
            for (int j = 0; j < i; j++) { // i index len <= j index len since A is non increasing
                if (A[i][0] <= A[j][0] && A[i][1] <= A[j][1] && A[i][2] <= A[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Box[] input = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32) };
        BoxStacking driver = new BoxStacking();
        System.out.println(driver.maxHeight(input));
    }
}
