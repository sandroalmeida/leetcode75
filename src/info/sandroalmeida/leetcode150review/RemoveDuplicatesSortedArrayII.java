package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* Leetcode 26
*  each element can appears at most twice */
public class RemoveDuplicatesSortedArrayII {
  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,1,2,3,3};
    System.out.println(removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }

  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;

    int i = 1; // Pointer to iterate through the array
    int j = 1; // Pointer to track position for valid elements
    int count = 1; // Count of occurrences of the current element

    while (i < nums.length) {
      if (nums[i] == nums[i - 1]) {
        count++;
        if (count > 2) {
          i++;
          continue;
        }
      } else {
        count = 1;
      }
      nums[j] = nums[i];
      j++;
      i++;
    }
    return j;
  }
}
