package info.sandroalmeida.educative.grokking_code_interview._3_sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
* source -> aaabcadfaaaaaaaabcdaaaaafaaaaa
* target -> bcdf
* possibles answers -> bcadf bcdaaaaaf
* minimum window -> bcadf
*
* Observations:
* window length >= target length
* if I use a map of chars of the target and start deleting items when zero means find candidate
* left pointer starting from first letter target index
* move right until find candidate
* compare candidate with current candidate for keeping the smaller
* move left for the next first letter index
* if there's no next finish loop
* */

public class MinimumWindowSubsequence {
    public static String minWindow(String s, String t) {
        /*
        * Pseudo code
        * first loop while next index != -1
        * second loop while not finding candidate(map size > 0) or right pointer not at end
        * auxiliary functions:
        *   buildCharMap
        *   reducingMap
        *   main function
        * */

        String result = "";
        char firstChar = t.charAt(0);
        int left = s.indexOf(firstChar);
        while(left != -1) {
            int right = left;
            Map<Character, Integer> map = buildCharMap(t);
            while(right < s.length() && !map.isEmpty()) {
                char currentChar = s.charAt(right);
                reducingMap(map, currentChar);
                if(map.isEmpty()) {
                    String candidate = s.substring(left, right + 1);
                    if(result.isEmpty()) result = candidate;
                    else if(result.length() > candidate.length()) result = candidate;
                    break;
                }
                right++;
            }
            if(s.substring(left + 1).indexOf(firstChar) == -1)
                break;
            else
                left = s.substring(left + 1).indexOf(firstChar) + left + 1;
        }
        return result;
    }

    private static Map<Character, Integer> buildCharMap(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c: chars) {
            if(charMap.containsKey(c))
                charMap.put(c, charMap.get(c) + 1);
            else
                charMap.put(c, 1);
        }
        return charMap;
    }

    private static void reducingMap(Map<Character, Integer> map, char charKey) {
        if(map.containsKey(charKey)) {
            if(map.get(charKey) == 1) {
                map.remove(charKey);
            } else{
                map.put(charKey, map.get(charKey) - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "fgrqsqsnodwmxzkzxwqegkndaa";
        String t = "kzed";
        System.out.println(minWindow(s, t));

    }


}
