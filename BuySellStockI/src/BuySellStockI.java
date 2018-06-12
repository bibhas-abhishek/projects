/**
 * Bibhas Abhishek
 * [bibhas_01@hotmail.com]
 * 12 Jun 2018
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solution/
 * https://github.com/bibhas-abhishek/projects/tree/master/BuySellStockI
 **/

public class BuySellStockI {

    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
