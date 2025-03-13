package info.sandroalmeida.leetcode150review;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

  public static void main(String[] args) {
    System.out.println(romanToInt("CCCLCIII"));
  }

  public static int romanToInt(String s) {
    Map<Character, Integer> values = new HashMap<>();
    values.put('I', 1);
    values.put('V', 5);
    values.put('X', 10);
    values.put('L', 50);
    values.put('C', 100);
    values.put('D', 500);
    values.put('M', 1000);

    char[] chars = s.toCharArray();
    int total = 0;

    for(int i = 0; i < chars.length; i++) {
      char current = chars[i];
      int value = values.get(current);
      if(i == chars.length - 1) {
        total += value;
      } else{
        int nextValue = values.get(chars[i+1]);
        if(nextValue > value) {
          total += nextValue - value;
          i++;
        } else{
          total += value;
        }
      }
    }
    return total;
  }
}
