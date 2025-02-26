package info.sandroalmeida.educative.grokking_code_interview;

import java.util.*;

public class QuickReview {

  public static void main(String[] args) {
//    int[] nums = {2,7,11,15};
//    int[] result = twoSum(nums, 9);
//    System.out.println(Arrays.toString(result));

//    System.out.println(longestSubstring("abcabcabc"));

//    int[] nums1 = {1,2,3};
//    int[] nums2 = {4,5,6};
//    System.out.println(returnMedian(nums1, nums2));
//    System.out.println(findMedianSortedArrays(nums1, nums2));
//    System.out.println(longestPalindrome("aaabba"));
//    System.out.println(validParenthesis("([[]])()"));
    System.out.println(firstUniqueCharacterString("leetcode"));

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

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // nums1 will be the smaller array
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length, n = nums2.length;
    int low = 0, high = m;
    while (low <= high) {
      int partitionX = (low + high) / 2; // Partition index for nums1
      int partitionY = (m + n + 1) / 2 - partitionX; // Partition index for nums2

      // Handling edge cases where partition is at start or end
      int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
      int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

      int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
      int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        // Found the correct partition
        if ((m + n) % 2 == 0) {
          return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) {
        // Too far right in nums1, move left
        high = partitionX - 1;
      } else {
        // Too far left in nums1, move right
        low = partitionX + 1;
      }
    }
    throw new IllegalArgumentException("Input arrays are not sorted properly.");
  }

  public static String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return "";
    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
      // Check for odd-length palindromes (centered at i)
      int len1 = expandAroundCenter(s, i, i);
      // Check for even-length palindromes (centered between i and i+1)
      int len2 = expandAroundCenter(s, i, i + 1);

      int maxLen = Math.max(len1, len2);

      // Update the longest palindrome boundaries
      if (maxLen > end - start) {
        start = i - (maxLen - 1) / 2;
        end = i + maxLen / 2;
      }
    }

    return s.substring(start, end + 1);
  }

  private static int expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1; // Return length of palindrome found
  }

  private static boolean validParenthesis(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c: s.toCharArray()) {
        if  ( !stack.isEmpty() &&
              ((stack.peek() == '(' && c == ')') ||
               (stack.peek() == '[' && c == ']') ||
               (stack.peek() == '{' && c == '}'))
            ){
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    return stack.isEmpty();
  }

  public static int firstUniqueCharacterString(String s) {
      Map<Character, Integer> charCount = new HashMap<>();

      for (char c : s.toCharArray()) {
        charCount.put(c, charCount.getOrDefault(c, 0) + 1);
      }

      for (int i = 0; i < s.length(); i++) {
        if (charCount.get(s.charAt(i)) == 1) {
          return i;
        }
      }

      return -1;
  }
}
