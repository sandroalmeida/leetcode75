package info.sandroalmeida.leetcode75.random_exercises;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * For two strings s and t, we say "t divides s" if and only if
 * s = t + ... + t (i.e., t is concatenated with itself one or more times).
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * Constraints:
 * 1 <= str1.length, str2.length <= 1000
 * str1 and str2 consist of English uppercase letters.*/
public class GreatestCommonDivisorStrings {
    public static String gcdOfStrings(String str1, String str2) {
        List<String> candidates1 = extractSubstringsCandidates(str1);
        List<String> candidates2 = extractSubstringsCandidates(str2);
        String maxDivisor = "";
        for(String item: candidates1) {
            if(candidates2.contains(item) && item.length() > maxDivisor.length())
                maxDivisor = item;
        }
        return maxDivisor;
    }

    public static boolean checkCandidate(String candidate, String str) {
        if(str.length() % candidate.length() != 0)
            return false;
        int repetitions = str.length() / candidate.length();
        StringBuilder sb = new StringBuilder();
        while(repetitions > 0){
            sb.append(candidate);
            repetitions--;
        }
        return sb.toString().equals(str);
    }

    public static List<String> extractSubstringsCandidates(String str) {
        Set<String> list = new HashSet<>();
        for(int i = 1; i <= str.length(); i++) {
            String subStr = str.substring(0, i);
            if(checkCandidate(subStr, str))
                list.add(subStr);
        }
        return list.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABCABC", "ABC"));
    }
}
