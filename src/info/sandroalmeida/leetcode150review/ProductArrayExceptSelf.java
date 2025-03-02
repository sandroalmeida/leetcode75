package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

public class ProductArrayExceptSelf {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
  }

  //Example 1:
  //Input: nums = [1,2,3,4] -> L[1,1,2,6] R[24,12,4,1] F[24,12,8,6]
  //Output: [24,12,8,6]
  //Example 2:
  //Input: nums = [-1,1,0,-3,3]
  //Output: [0,0,9,0,0]
  public static int[] productExceptSelf(int[] nums) {
    int[] left = new int[nums.length];
    left[0] = 1;
    int[] right = new int[nums.length];
    right[nums.length - 1] = 1;

    for(int i = 1; i < nums.length; i++) {
      left[i] = left[i - 1] * nums[i - 1];
    }
    for(int i = nums.length - 2; i >= 0; i--) {
      right[i] = right[i + 1] * nums[i + 1];
    }
    int[] result = new int[nums.length];
    for(int i = 0; i < result.length; i++) {
      result[i] = left[i] * right[i];
    }
    return result;
  }
}
