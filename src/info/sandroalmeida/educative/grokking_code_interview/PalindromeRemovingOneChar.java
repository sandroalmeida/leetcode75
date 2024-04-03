package info.sandroalmeida.educative.grokking_code_interview;

public class PalindromeRemovingOneChar {
    public static boolean isPalindrome(String s) {

        boolean skip = true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            // if chars mismatch check for skip
            if(s.charAt(left) != s.charAt(right)) {
                if(skip){
                    // trying to skip left or right if match
                    skip = false;
                    if(s.charAt(left + 1) == s.charAt(right)) left++;
                    else if(s.charAt(left) == s.charAt(right - 1)) right--;
                    // return false if skipping doesn't work
                    else return false;
                } else{
                    // return false if skip already used
                    return false;
                }

            }
            // if chars match continue moving pointers inwards
            left++;
            right--;
        }
        // return true if mismatch was not found or skipped more than once
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abbababa"));
    }
}
