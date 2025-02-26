package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* Leetcode 27*/
public class RemoveElement {
  public static void main(String[] args) {
    int[] nums = {3};
    System.out.println(removeElement2(nums, 3));
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

  public static int removeElement2(int[] nums, int val) {
    // slow pointer starts at beginning and move only when valid entry is
    // identified by fast pointer
    // this way fast pointer brings all elements that matters to beginning
    // and slow pointer will be at the end of valid part of the array
    // when the fast point finish the array
    int slow = 0;

    for (int fast = 0; fast < nums.length; fast++) {
      if (nums[fast] != val) {
        nums[slow] = nums[fast];
        slow++;
      }
    }
    return slow;
  }
}
