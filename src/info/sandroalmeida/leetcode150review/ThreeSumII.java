package info.sandroalmeida.leetcode150review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumII {
  public static void main(String[] args) {
    System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for(int i = 0; i < nums.length; i++) {
      int left = i + 1, right = nums.length - 1;
      int target = 0 - nums[i];

      // if current number equals previous skip to avoid duplication
      if(i != 0 && nums[i - 1] == nums[i]) {
        continue;
      }

      while(left < right) {
        int currentSum = nums[left] + nums[right];
        if(currentSum > target) {
          right--;
        } else if(currentSum < target) {
          left++;
        } else{
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
          // another extra check to avoid duplications
          while(left < right && nums[left] == nums[left - 1])
            left++;
        }
      }
    }

    return result;
  }
}
