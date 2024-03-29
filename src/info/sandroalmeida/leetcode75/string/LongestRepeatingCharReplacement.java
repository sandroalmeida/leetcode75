package info.sandroalmeida.leetcode75.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * */
public class LongestRepeatingCharReplacement {

    public static int characterReplacement(String s, int k) {
        int left = 0, right = 0;
        int maxSub = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int mostFrequent = 0;

        while(right < s.length()){
            charMap.put(s.charAt(right), charMap.getOrDefault(s.charAt(right),0) + 1);
            mostFrequent = Math.max(mostFrequent, charMap.get(s.charAt(right)));

            while((right - left + 1) - mostFrequent > k){
                charMap.put(s.charAt(left), charMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            maxSub = Math.max(maxSub, (right - left + 1));
            right++;
        }
        return maxSub;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 0));
    }
}
