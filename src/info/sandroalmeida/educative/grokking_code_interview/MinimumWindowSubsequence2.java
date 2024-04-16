package info.sandroalmeida.educative.grokking_code_interview;

public class MinimumWindowSubsequence2 {
    public static String minWindow(String s, String t) {
        String result = "";
        char firstChar = t.charAt(0);
        int left = s.indexOf(firstChar);
        int right = left;
        String targetCopy = t;
        while(left != -1 && right < s.length()) {
            char currentChar = s.charAt(right);
            targetCopy = checkTarget(targetCopy, currentChar);
            if(targetCopy.isEmpty()) {
                String candidate = s.substring(left, right + 1);
                if(result.isEmpty() || result.length() > candidate.length())
                    result = candidate;
                if(s.indexOf(firstChar, left+1) == -1)
                    left = -1;
                else
                    left = s.indexOf(firstChar, left+1);
                right = left;
                targetCopy = t;
            } else {
                right++;
            }
        }
        return result;
    }

    private static String checkTarget(String str, char currentChar) {
        if(str.charAt(0) == currentChar) {
            return str.substring(1);
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "abcdbebe";
        String t = "bbe";
        System.out.println(minWindow(s, t));
    }
}
