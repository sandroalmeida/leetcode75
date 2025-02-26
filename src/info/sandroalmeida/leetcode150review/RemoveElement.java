package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* Leetcode 27*/
public class RemoveElement {
  public static void main(String[] args) {
    int[] nums = {3};
    System.out.println(removeElement(nums, 3));
    System.out.println(Arrays.toString(nums));
  }

  public static int removeElement(int[] nums, int val) {
    // create a pointer in the last position to keep removed elements
    int replaceIdx = nums.length - 1;
    int i = 0;

    // loop through out the array until i became >= replaceIdx
    while (i <= replaceIdx) {
      if (nums[i] == val) {
        int temp = nums[i];
        nums[i] = nums[replaceIdx];
        nums[replaceIdx] = temp;
        // when swap is done don't change i only replaceIdx
        replaceIdx--;
      } else {
        // when swap doesn't happen proceed the loop
        i++;
      }
    }
    return i;
  }
}
