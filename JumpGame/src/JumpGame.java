/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: JumpGame
*- 18 Nov 2021 6:29 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
* https://leetcode.com/problems/jump-game
-------------------------------------------*/

public class JumpGame {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(n - 1, nums[i] + i);
            for (int j = i + 1; j <= maxJump; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
