package info.sandroalmeida.leetcode150review;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  public static void main(String[] args) {
    System.out.println(wordPattern( "abc", "dog cat dog"));
  }

  public static boolean wordPattern(String pattern, String s) {
    Map<Character, String> charString = new HashMap<>();
    Map<String, Character> stringChar = new HashMap<>();
    char[] chars = pattern.toCharArray();
    String[] words = s.split(" ");

    if(chars.length != words.length)
      return false;

    for(int i = 0; i < chars.length; i++) {
      if(charString.containsKey(chars[i])) {
        String mappedWord = charString.get(chars[i]);
        if(!mappedWord.equals(words[i]) || stringChar.get(mappedWord) != chars[i]){
          return false;
        }
      } else if(stringChar.containsKey(words[i])) {
        char mappedChar = stringChar.get(words[i]);
        if(mappedChar != chars[i]) {
          return false;
        }
      } else{
        charString.put(chars[i], words[i]);
        stringChar.put(words[i], chars[i]);
      }
    }
    return true;
  }
}
