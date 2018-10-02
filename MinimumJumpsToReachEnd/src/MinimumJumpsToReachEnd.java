/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 02 Oct 2018
 * https://leetcode.com/problems/jump-game-ii/description/
 * https://github.com/bibhas-abhishek/projects/tree/master/MinimumJumpsToReachEnd
 */

public class MinimumJumpsToReachEnd {

    private int minJumps(int arr[], int l, int h) {
        if (arr[l] == 0 || l == h)
            return 0;

        int result = Integer.MAX_VALUE;
        for (int k = l + 1; k <= Math.min(l + arr[l], h); k++) {
            int jump = minJumps(arr, k, h);
            result = Math.min(jump + 1, result);
        }
        return result;
    }

    private int minJumpsDP(int arr[], int n) {
        if (n < 2 || arr[0] == 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = 0; // for explanation purposes
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (j + arr[j] >= i)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }

    private int minJumpsGreedy(int[] arr) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + arr[i]);
            if (i == curEnd) {
                jumps += 1;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }


    public static void main(String[] args) {
        MinimumJumpsToReachEnd obj = new MinimumJumpsToReachEnd();
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println(obj.minJumps(arr, 0, arr.length - 1));
        System.out.println(obj.minJumpsDP(arr, arr.length));
        System.out.println(obj.minJumpsGreedy(arr));
    }

}
