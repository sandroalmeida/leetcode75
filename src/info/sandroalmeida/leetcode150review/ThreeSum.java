package info.sandroalmeida.leetcode150review;

import java.time.chrono.MinguoEra;
import java.util.*;

public class ThreeSum {
  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    for(int i = 0; i < nums.length - 1; i++) {
      int target = 0 - nums[i];
      int[] partialNums = Arrays.copyOfRange(nums, i + 1, nums.length - 1);
      List<List<Integer>> pairResults = twoSum(partialNums, target);
      if(!pairResults.isEmpty()) {
        for(List<Integer> pair: pairResults) {
          result.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
        }
      }
    }

    return result;
  }

  private static List<List<Integer>> twoSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < nums.length; i++) {
      if(set.contains(target - nums[i])) {
        result.add(Arrays.asList((target - nums[i]), nums[i]));
      }
      set.add(nums[i]);
    }
    return result;
  }
}
