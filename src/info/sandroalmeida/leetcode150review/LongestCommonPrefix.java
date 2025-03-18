package info.sandroalmeida.leetcode150review;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = new String[]{"float", "flower", "flying"};
    System.out.println(longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    StringBuilder result = new StringBuilder();

    int shortLength = Integer.MAX_VALUE;
    for(String s: strs) {
      shortLength = Math.min(shortLength, s.length());
    }

    for(int i = 0; i < shortLength; i++) {
      char currentChar = strs[0].charAt(i);
      boolean isMatch = true;
      for(String s: strs) {
        if(s.charAt(i) != currentChar) {
          isMatch = false;
          break;
        }
      }
      if(!isMatch) {
        result.append(strs[0].subSequence(0,i));
        break;
      }
    }
    return result.toString();
  }
}
