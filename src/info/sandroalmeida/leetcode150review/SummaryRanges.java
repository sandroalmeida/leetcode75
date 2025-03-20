package info.sandroalmeida.leetcode150review;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

  public static void main(String[] args) {
    System.out.println(summaryRanges(new int[]{0}));
  }

  //Input: nums = [0,1,2,4,5,7]
  //Output: ["0->2","4->5","7"]
  public static List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if(nums.length == 0) return result;

    int left = 0;
    for(int right = 0; right < nums.length; right++) {
      if(right == nums.length - 1 || nums[right + 1] != nums[right] + 1) {
        if(right == left) {
          result.add(Integer.toString(nums[left]));
        } else{
          result.add(Integer.toString(nums[left]) + "->" + Integer.toString(nums[right]));
        }
        left = right + 1;
      }
    }
    return result;
  }
}
