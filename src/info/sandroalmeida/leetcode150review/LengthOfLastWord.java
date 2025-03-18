package info.sandroalmeida.leetcode150review;

public class LengthOfLastWord {

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World"));
    System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
  }

  public static int lengthOfLastWord(String s) {
    s = s.trim();
    String[] words = s.split(" ");
    return words[words.length - 1].length();
  }
}
