package info.sandroalmeida.educative.grokking_code_interview;

import java.util.*;

public class QuickReview {

  public static void main(String[] args) {
//    int[] nums = {2,7,11,15};
//    int[] result = twoSum(nums, 9);
//    System.out.println(Arrays.toString(result));

    System.out.println(longestSubstring("abcabcabc"));

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
}
