package info.sandroalmeida.leetcode150review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagConversion {

  public static void main(String[] args) {
    System.out.println(convert("AB", 1));
  }

  //Example 1:
  //
  //Input: s = "PAYPALISHIRING", numRows = 3
  //Output: "PAHNAPLSIIGYIR"
  //
  ////Example 2:
  //Input: s = "PAYPALISHIRING", numRows = 4
  //Output: "PINALSIGYAHRPI"
  //Explanation:
  //P     I    N
  //A   L S  I G
  //Y A   H R
  //P     I
  //PAYPALISHIRING
  public static String convert(String s, int numRows) {
    if(numRows == 1) return s;
    String[] rows = new String[numRows];
    Arrays.fill(rows, "");

    boolean isAscending = true;
    int currentRow = 0;
    for(int i = 0; i < s.length(); i++) {
      rows[currentRow] = rows[currentRow] + s.charAt(i);
      if(currentRow == rows.length - 1) {
        isAscending = false;
      } else if(currentRow == 0){
        isAscending = true;
      }
      currentRow = isAscending ? currentRow + 1 : currentRow - 1;
    }
    StringBuilder result = new StringBuilder();
    for(String str: rows){
      result.append(str);
    }
    return result.toString();
  }
}
