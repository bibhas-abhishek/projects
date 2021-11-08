/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- projects: WeightedJobScheduling
*- 08 Nov 2021 9:05 PM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

import java.util.Arrays;

public class WeightedJobScheduling {

    private static class Job {

        private int start;
        private int end;
        private int profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int maximumProfit(Job[] job) {
        Arrays.sort(job, (o1, o2) -> o1.end - o2.end);
        int[] dp = new int[job.length];
        dp[0] = job[0].profit;
        int maximumProfit = Integer.MIN_VALUE;
        for (int i = 1; i < job.length; i++) {
            dp[i] = job[i].profit;
            for (int j = 0; j < i; j++) {
                if (job[i].start >= job[j].end) {
                    dp[i] = Math.max(dp[i], dp[j] + job[i].profit);
                }
            }
            maximumProfit = Math.max(maximumProfit, dp[i]);
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        WeightedJobScheduling obj = new WeightedJobScheduling();
        Job[] jobs = new Job[6];
        jobs[0] = new Job(1, 3, 5);
        jobs[1] = new Job(2, 5, 6);
        jobs[2] = new Job(4, 6, 5);
        jobs[3] = new Job(6, 7, 4);
        jobs[4] = new Job(5, 8, 11);
        jobs[5] = new Job(7, 9, 2);
        System.out.println(obj.maximumProfit(jobs));
    }
}
