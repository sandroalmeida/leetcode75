package info.sandroalmeida.leetcode150review;

import com.sun.source.tree.BreakTree;

/* Leetcode 122 */
public class BestTimeBuySellStockII {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7,1,4,5,3,6,4}));
  }

  //Input: prices = [7,1,4,5,3,6,4]
  //Output: 7
  //Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
  //Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
  //Total profit is 4 + 3 = 7.
  public static int maxProfit(int[] prices) {
    int total = 0;
    int minPrice = Integer.MAX_VALUE;
    int maxPrice = minPrice;

    for(int i = 0; i < prices.length; i++) {
      if (prices[i] < maxPrice) {
        total += maxPrice - minPrice;
        minPrice = prices[i];
        maxPrice = minPrice;
      } else {
        maxPrice = prices[i];
      }
    }
    total += maxPrice - minPrice;
    return total;
  }
}
