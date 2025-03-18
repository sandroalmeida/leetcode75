package info.sandroalmeida.leetcode150review;

public class ReverseWordsString {

  public static void main(String[] args) {
    System.out.println(reverseWords("  hello world  "));
    System.out.println(reverseWords("a good   example"));
  }

  public static String reverseWords(String s) {
    //trim the original string
    //split into array of strings
    //build result string traversing array of string in reverse
    StringBuilder sb = new StringBuilder();

    s = s.trim();
    String[] words = s.split(" ");
    for(int i = words.length - 1; i >= 0; i--) {
      if(words[i].isEmpty()) continue;
      sb.append(words[i].trim());
      if(i != 0) sb.append(" ");
    }
    return sb.toString();
  }
}
