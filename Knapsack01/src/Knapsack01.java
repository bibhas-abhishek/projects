import java.util.HashMap;

/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 11 Apr 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/Knapsack01
 **/

public class Knapsack01 {

    private static class MemoKey {

        int remainingWeight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MemoKey MemoKey = (MemoKey) o;

            if (remainingWeight != MemoKey.remainingWeight) return false;
            return remainingItems == MemoKey.remainingItems;
        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }

    }

    public static void main(String[] args) {
        int value[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int weight[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        System.out.println(knapsack01DP(value, weight, 30));
    }

    private static int knapsack01DP(int[] values, int[] weight, int maxWeight) {
        return knapsack01DPUtil(values, weight, maxWeight, values.length, 0, new HashMap<MemoKey, Integer>());
    }

    private static int knapsack01DPUtil(int[] values, int[] weight, int remainingWeight, int totalItems, int currentItem,
                                        HashMap<MemoKey, Integer> memo) {
        if (currentItem >= totalItems || remainingWeight <= 0)
            return 0;

        // currentItem is index of current item
        MemoKey memoKey = new MemoKey();
        memoKey.remainingWeight = remainingWeight;
        memoKey.remainingItems = totalItems - currentItem - 1;
        if (memo.containsKey(memoKey))
            return memo.get(memoKey);

        int maxValue;
        if (remainingWeight < weight[currentItem])
            maxValue = knapsack01DPUtil(values, weight, remainingWeight, totalItems, currentItem + 1, memo);  // skip current item
        else
            return Math.max(values[currentItem] +
                            knapsack01DPUtil(values, weight, remainingWeight - weight[currentItem], totalItems, currentItem + 1, memo), // take current item
                    knapsack01DPUtil(values, weight, remainingWeight, totalItems, currentItem + 1, memo)); //skip current item

        memo.put(memoKey, maxValue);
        return maxValue;
    }

}
