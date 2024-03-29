package info.sandroalmeida.educative.grokking_code_interview;

public class Palindrome{
    public static boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while(start != end && start <= end) {
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String test = "abadba";
        System.out.println(isPalindrome(test));
    }
}