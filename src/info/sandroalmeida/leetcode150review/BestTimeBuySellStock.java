package info.sandroalmeida.leetcode150review;

/* Leetcode 121 */
public class BestTimeBuySellStock {
  public static void main(String[] args) {
    System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
  }

  //Input: prices = [7,1,5,3,6,4]
  //Output: 5
  //Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
  //Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
  public static int maxProfit(int[] prices) {
    int minValue = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int i = 0; i < prices.length; i++) {
      if(prices[i] < minValue) {
        minValue = prices[i];
      } else if(prices[i] - minValue > maxProfit) {
        maxProfit = prices[i] - minValue;
      }
    }
    return maxProfit;
  }
}
