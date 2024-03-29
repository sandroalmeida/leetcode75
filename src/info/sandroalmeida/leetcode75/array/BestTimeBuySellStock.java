package info.sandroalmeida.leetcode75.array;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * */

public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {
        int bestValueBuy = Integer.MAX_VALUE;
        int indexBuy = -1;
        int bestValueSell = Integer.MIN_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            int current = prices[i];

            if(indexBuy == -1){
                bestValueBuy = current;
                indexBuy = i;
                continue;
            }

            if(current < bestValueBuy && i < prices.length - 1){
                bestValueBuy = current;
                indexBuy = i;
                bestValueSell = Integer.MIN_VALUE;
            }else if(current > bestValueSell && current > bestValueBuy && i > indexBuy){
                bestValueSell = current;
                maxProfit = Math.max(maxProfit, bestValueSell - bestValueBuy);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices_1 = new int[]{ 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices_1));

        int[] prices_2 = new int[]{ 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices_2));

        int[] prices_3 = new int[]{ 2, 4, 1 };
        System.out.println(maxProfit(prices_3));

        int[] prices_4 = new int[]{ 2, 1, 2, 0, 1, 2 };
        System.out.println(maxProfit(prices_4));
    }
}
