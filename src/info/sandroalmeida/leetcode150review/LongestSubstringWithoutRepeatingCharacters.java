package info.sandroalmeida.leetcode150review;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
  }

  public static int lengthOfLongestSubstring(String s) {
    int maxLength = 0;

    Set<Character> charSet = new HashSet<>();
    int left = 0, right = 0;
    while(right < s.length()) {
      if(charSet.contains(s.charAt(right))) {
        charSet.remove(s.charAt(left));
        left++;
      } else{
        charSet.add(s.charAt(right));
        right++;
        maxLength = Math.max(maxLength, right - left);
      }
    }
    return maxLength;
  }
}
