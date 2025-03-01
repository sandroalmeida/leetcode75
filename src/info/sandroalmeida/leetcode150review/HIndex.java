package info.sandroalmeida.leetcode150review;

import java.util.Arrays;

/* leetcode 274 */
public class HIndex {
  public static void main(String[] args) {
    System.out.println(hIndex(new int[]{3,0,6,1,5}));
  }

  //Input: citations = [3,0,6,1,5]
  //Output: 3
  //Explanation: [3,0,6,1,5] means the researcher has 5 papers in total
  //and each of them had received 3, 0, 6, 1, 5 citations respectively.
  //Since the researcher has 3 papers with at least 3 citations each
  //and the remaining two with no more than 3 citations each, their h-index is 3.
  public static int hIndex(int[] citations) {
    //after sorting the array
    //start the h-index with the length
    //go through the array checking if the current number is >= current h-index
    //if false reduce h-index by one
    //when achieve last position return minimal between h-index and last number
    Arrays.sort(citations);
    int h_index = citations.length;
    for(int i = 0; i < citations.length; i++) {
      if (citations[i] < h_index) {
        if (i == citations.length - 1) {
          h_index = Math.min(citations[i], h_index);
        } else{
          h_index--;
        }
      }
    }
    return h_index;
  }
}
