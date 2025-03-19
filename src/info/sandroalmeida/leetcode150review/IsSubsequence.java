package info.sandroalmeida.leetcode150review;

public class IsSubsequence {

  public static void main(String[] args) {
    System.out.println(isSubsequence("aec", "abcde"));
  }

  public static boolean isSubsequence(String s, String t) {
    if(s.isEmpty()) return true;
    int s_idx = 0, t_idx = 0;
    while(s_idx < s.length() && t_idx < t.length()) {
      if(s.charAt(s_idx) == t.charAt(t_idx)) {
        s_idx++;
      }
      t_idx++;
      if(s_idx == s.length()) return true;
    }
    return false;
  }
}
