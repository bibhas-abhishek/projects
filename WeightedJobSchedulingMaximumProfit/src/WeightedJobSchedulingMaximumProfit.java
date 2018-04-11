import java.util.Arrays;
import java.util.Comparator;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 11 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/WeightedJobSchedulingMaximumProfit
 **/

public class WeightedJobSchedulingMaximumProfit {


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

    public static void main(String[] args) {
        Job jobs[] = new Job[6];
        jobs[0] = new Job(1, 3, 5);
        jobs[1] = new Job(2, 5, 6);
        jobs[2] = new Job(4, 6, 5);
        jobs[3] = new Job(6, 7, 4);
        jobs[4] = new Job(5, 8, 11);
        jobs[5] = new Job(7, 9, 2);
        System.out.println(maximumProfit(jobs));
    }

    private static int maximumProfit(Job[] job) {
        Arrays.sort(job, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.end - o2.end;
            }
        });

        int[] memo = new int[job.length];
        memo[0] = job[0].profit;
        for (int i = 1; i < job.length; i++) {
            memo[i] = job[i].profit;
            for (int j = 0; j < i; j++) {
                if (job[i].start >= job[j].end)
                    memo[i] = Math.max(memo[i], memo[j] + job[i].profit);
            }
        }

        int maximumProfit = Integer.MIN_VALUE;
        for (int i : memo) {
            if (i > maximumProfit)
                maximumProfit = i;
        }
        return maximumProfit;
    }

}
