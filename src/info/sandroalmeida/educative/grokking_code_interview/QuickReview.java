package info.sandroalmeida.educative.grokking_code_interview;

import java.util.*;

public class QuickReview {

  public static void main(String[] args) {
//    int[] nums = {2,7,11,15};
//    int[] result = twoSum(nums, 9);
//    System.out.println(Arrays.toString(result));

//    System.out.println(longestSubstring("abcabcabc"));

    int[] nums1 = {1,2,3};
    int[] nums2 = {4,5,6};
    System.out.println(returnMedian(nums1, nums2));

  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> seenNumbers = new HashMap<>();
    int[] result = new int[2];

    for (int i = 0; i < nums.length; i++) {
      int currentNumber = nums[i];
      int difference = target - currentNumber;
      if (seenNumbers.containsKey(difference)) {
        return new int[]{seenNumbers.get(difference), i};
      } else {
        seenNumbers.put(nums[i], i);
      }
    }
    return null;
  }

  public static int longestSubstring(String s) {
    Set<Character> charSet = new HashSet<>();
    int left = 0, right = 0, longest = 0;

    while (right < s.length()) {
      char rightChar = s.charAt(right);
      if (!charSet.contains(rightChar)) {
        longest = Math.max(right - left + 1, longest);
        charSet.add(rightChar);
        right++;
      } else {
        char leftChar = s.charAt(left);
        charSet.remove(leftChar);
        left++;
      }
    }

    return longest;
  }

  public static float returnMedian(int[] nums1, int[] nums2) {
    List<Integer> merged = new ArrayList<>();

    int idx1 = 0, idx2 = 0;
    while (idx1 <  nums1.length && idx2 < nums2.length) {
      if (nums1[idx1] < nums2[idx2]) {
        merged.add(nums1[idx1]);
        idx1++;
      } else {
        merged.add(nums2[idx2]);
        idx2++;
      }
    }
    while (idx1 <  nums1.length) {
      merged.add(nums1[idx1]);
      idx1++;
    }
    while (idx2 < nums2.length) {
      merged.add(nums2[idx2]);
      idx2++;
    }

    int mIdx = merged.size() / 2;
    if (merged.size() % 2 == 0) {
      return (float) (merged.get(mIdx) + merged.get(mIdx - 1)) / 2;
    } else {
      return merged.get(mIdx);
    }
  }
}
