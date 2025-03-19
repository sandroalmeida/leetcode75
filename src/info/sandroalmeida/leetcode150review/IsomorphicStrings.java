package info.sandroalmeida.leetcode150review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {

  public static void main(String[] args) {
    System.out.println(isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
  }

  public static boolean isIsomorphic(String s, String t) {
    return transformStringIndices(s).equals(transformStringIndices(t));
  }

  private static String transformStringIndices(String str) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    for(int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);

      if(!map.containsKey(current)) {
        map.put(current, i);
      }

      sb.append(Integer.toString(map.get(current)));
      sb.append(" ");
    }
    return sb.toString();
  }
}
