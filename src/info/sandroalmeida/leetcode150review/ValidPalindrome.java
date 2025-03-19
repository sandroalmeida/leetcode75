package info.sandroalmeida.leetcode150review;

public class ValidPalindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  public static boolean isPalindrome(String s) {
    s = s.toLowerCase();
    int start = 0, end = s.length() - 1;

    while(start <= end) {
      char startChar = s.charAt(start);
      char endChar = s.charAt(end);

      // ignoring chars diff than digit or letter
      // this function only validate palindrome considering valid chars
      if(!Character.isLetterOrDigit(startChar)) {
        start++;
        continue;
      } else if(!Character.isLetterOrDigit(endChar)) {
        end--;
        continue;
      }

      if(startChar != endChar)
        return false;
      start++;
      end--;
    }
    return true;
  }
}
