package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

public class TwoSumII {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int start = 0, end = numbers.length - 1;

    while(start < end) {
      int currentSum = numbers[start] + numbers[end];
      if(currentSum < target)  {
        start++;
      } else if(currentSum > target) {
        end--;
      } else{
        result[0] = start + 1;
        result[1] = end + 1;
        break;
      }
    }
    return result;
  }
}
