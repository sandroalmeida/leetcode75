package info.sandroalmeida.leetcode150review;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(3999));
  }
  private static final String[] thousands = {"","M","MM","MMM"};
  private static final String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
  private static final String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
  private static final String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};

  public static String intToRoman(int num) {
    return  thousands[num / 1000] +
            hundreds[(num % 1000) / 100] +
            tens[(num % 100) / 10] +
            ones[num % 10];
  }
}
