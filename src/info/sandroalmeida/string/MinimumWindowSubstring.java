package info.sandroalmeida.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 *
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 *
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 *
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * */
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> charMapT = new HashMap<>();
        Map<Character, Integer> charMapS = new HashMap<>();

        for(char c: t.toCharArray())
            charMapT.put(c, charMapT.getOrDefault(c, 0) + 1);

        int left = 0, right = 0;
        String substring = "";

        while(right < s.length()){
            charMapS.put(s.charAt(right), charMapS.getOrDefault(s.charAt(right), 0) + 1);
            if(charMapS.size() >= charMapT.size()){
                while(isSubsetMap(charMapS, charMapT)) {
                    if (substring.equals("") || substring.length() > (right - left + 1)) {
                        substring = s.substring(left, right + 1);
                    }
                    charMapS.put(s.charAt(left), charMapS.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
            }
            right++;
        }
        return substring;
    }

    public static boolean isSubsetMap(Map<Character, Integer> s, Map<Character, Integer> t){
        for(Map.Entry<Character, Integer> item: t.entrySet()){
            if(s.getOrDefault(item.getKey(), 0) < item.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
