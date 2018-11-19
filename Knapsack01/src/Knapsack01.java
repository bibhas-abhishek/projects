import java.util.HashMap;
import java.util.Map;

/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 11 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/Knapsack01
 **/

public class Knapsack01 {

    public int knapsack01DP(int[] values, int[] weight, int maxWeight) {
        return knapsack01DPUtil(values, weight, maxWeight, 0, new HashMap<>());
    }

    private int knapsack01DPUtil(int[] values, int[] weight, int remainingWeight, int currentItem, Map<String, Integer> memo) {
        if (currentItem >= values.length || remainingWeight <= 0)
            return 0;

        // currentItem is index of current item
        int remainingItems = values.length - currentItem - 1;
        String key = remainingWeight + "-" + remainingItems;
        if (memo.containsKey(key))
            return memo.get(key);

        int maxValue;
        if (remainingWeight < weight[currentItem])
            maxValue = knapsack01DPUtil(values, weight, remainingWeight, currentItem + 1, memo);  // skip current item
        else
            return Math.max(values[currentItem] +
                            knapsack01DPUtil(values, weight, remainingWeight - weight[currentItem], currentItem + 1, memo), // take current item
                    knapsack01DPUtil(values, weight, remainingWeight, currentItem + 1, memo)); //skip current item

        memo.put(key, maxValue);
        return maxValue;
    }

    public static void main(String[] args) {
        int value[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int weight[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        System.out.println(new Knapsack01().knapsack01DP(value, weight, 30));
    }

}
