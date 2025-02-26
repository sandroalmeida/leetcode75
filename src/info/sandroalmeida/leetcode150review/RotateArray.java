package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* Leetcode 189 */
public class RotateArray {
  //Input: nums = [1,2,3,4,5,6,7], k = 3
  //Output: [5,6,7,1,2,3,4]
  //Explanation:
  //rotate 1 steps to the right: [7,1,2,3,4,5,6]
  //rotate 2 steps to the right: [6,7,1,2,3,4,5]
  //rotate 3 steps to the right: [5,6,7,1,2,3,4]

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,7};
    rotateSolution1(nums, 3);
    System.out.println(Arrays.toString(nums));
  }

  public static void rotateSolution1(int[] nums, int k) {
    if(nums.length <= 1) return;
    while(k > 0) {
      rotateOnce(nums);
      k--;
    }
  }

  private static void rotateOnce(int[] nums) {
    int temp = nums[nums.length - 1];
    for(int i = nums.length - 2; i >= 0; i--) {
      nums[i + 1] = nums[i];
    }
    nums[0] = temp;
  }
}
