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
    rotateSolution2(nums, 2);
    System.out.println(Arrays.toString(nums));
  }

  public static void rotateSolution1(int[] nums, int k) {
    if(nums.length <= 1) return;
    while(k > 0) {
      rotateOnce(nums);
      k--;
    }
  }

  public static void rotateSolution2(int[] nums, int k) {
    // I want to slice the array into 2 parts
    // example the array [1,2,3,4,5,6,7] with k=3 can be sliced as
    // [1,2,3,4] and [5,6,7]
    // then we can regroup the two parts putting the second before the first
    // if k is bigger than the array length
    // example the array [1,2] with k=3 we can use mod to define the cut
    // 3 % 2 = 1 slice will be [1] and [2] result [2,1]

    int cut = k < nums.length ? k : (k - nums.length - 1) % nums.length;
    System.out.println(cut);
    int[] part1 = Arrays.copyOfRange(nums, 0, cut);
    int[] part2 = Arrays.copyOfRange(nums, cut, nums.length);
    int[] temp = new int[nums.length];
    System.arraycopy(part2, 0, temp,0, part2.length);
    System.arraycopy(part1, 0, temp,part2.length, part1.length);
    System.arraycopy(temp, 0, nums,0, temp.length);
  }

  private static void rotateOnce(int[] nums) {
    int temp = nums[nums.length - 1];
    for(int i = nums.length - 2; i >= 0; i--) {
      nums[i + 1] = nums[i];
    }
    nums[0] = temp;
  }
}
