package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    int[] nums1 = {0,0,0,0,0};
    int[] nums2 = {1,2,3,4,5};
    merge(nums1, 0, nums2, 5);
    System.out.println(Arrays.toString(nums1));
  }

  /*
  * Leetcode 88
  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
  Output: [1,2,2,3,5,6]
  Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
  The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.*/
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    // use two pointers starting by positions m-1 and n-1
    // and extra pointer for last replacement position
    int p1 = m - 1, p2 = n - 1, replaceIdx = nums1.length - 1;
    // finish the loop when position 2 became negative
    while (p2 >= 0) {
      // compare which is bigger and move to end position
      if (p1 >= 0 && nums1[p1] > nums2[p2]) {
        // update position of the bigger item
        nums1[replaceIdx] = nums1[p1];
        p1--;
      } else {
        nums1[replaceIdx] = nums2[p2];
        p2--;
      }
      // update end position
      replaceIdx--;
    }
  }
}
