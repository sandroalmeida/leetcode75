package info.sandroalmeida.leetcode150review;

public class FindIndexFirstOccurrenceString {

  public static void main(String[] args) {
    String haystack = "asadbutsad";
    String needle = "sadc";

    System.out.println(strStr(haystack, needle));
  }

  public static int strStr(String haystack, String needle) {
    int m = needle.length();
    int n = haystack.length();

    for (int windowStart = 0; windowStart <= n - m; windowStart++) {
      for (int i = 0; i < m; i++) {
        if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
          break;
        }
        if (i == m - 1) {
          return windowStart;
        }
      }
    }

    return -1;
  }
}

