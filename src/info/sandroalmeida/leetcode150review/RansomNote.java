package info.sandroalmeida.leetcode150review;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

  public static void main(String[] args) {
    System.out.println(canConstruct("aa", "abc"));
  }

  //Input: ransomNote = "aa", magazine = "aab"
  //Output: true
  public static boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> mapCharsNote = new HashMap<>();
    for(char c: ransomNote.toCharArray()) {
      mapCharsNote.put(c, mapCharsNote.getOrDefault(c, 0) + 1);
    }

    for(char c: magazine.toCharArray()) {
      if(mapCharsNote.containsKey(c)) {
        if(mapCharsNote.get(c) == 1) {
          mapCharsNote.remove(c);
        } else{
          mapCharsNote.put(c, mapCharsNote.get(c) - 1);
        }
      }
    }
    return mapCharsNote.isEmpty();
  }
}
