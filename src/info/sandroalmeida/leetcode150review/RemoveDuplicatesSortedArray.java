package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* Leetcode 26 */
public class RemoveDuplicatesSortedArray {
  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,2,2,3,3,4};
    System.out.println(removeDuplicates(nums));
    System.out.println(Arrays.toString(nums));
  }

  public static int removeDuplicates(int[] nums) {
    int slow = 0;
    for (int fast = 0; fast < nums.length; fast++) {
      // if fast number not equals slow number copy and increment slow
      // make the swap after increment for the next comparison
      if (nums[slow] != nums[fast]) {
        slow++;
        nums[slow] = nums[fast];
      }
    }
    return slow + 1;
  }
}
