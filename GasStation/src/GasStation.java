/**
 * https://leetcode.com/problems/gas-station/description/
 */

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int end = 0;
        int start = gas.length - 1;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end += 1;
            }
            else {
                start -= 1;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 };
        int[] cost = { 3, 4, 5, 1, 2 };
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
}
