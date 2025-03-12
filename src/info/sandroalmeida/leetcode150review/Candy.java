package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* Leetcode 135*/
public class Candy {

  public static void main(String[] args) {
    System.out.println(candy(new int[]{1,2,2}));
  }

  //Input: ratings = [1,0,2]
  //Output: 5
  //Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

  //Input: ratings = [1,2,2]
  //Output: 4
  //Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
  //The third child gets 1 candy because it satisfies the above two conditions.
  public static int candy(int[] ratings) {
    int[] rightToLeft = new int[ratings.length];
    int[] leftToRight = new int[ratings.length];
    Arrays.fill(rightToLeft, 1);
    Arrays.fill(leftToRight, 1);

    for(int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        rightToLeft[i] = rightToLeft[i - 1] + 1;
      }
    }

    for(int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        leftToRight[i] = leftToRight[i + 1] + 1;
      }
    }

    int totalCandies = 0;
    for(int i = 0; i < rightToLeft.length; i++) {
      totalCandies += Math.max(rightToLeft[i], leftToRight[i]);
    }
    return totalCandies;
  }
}
