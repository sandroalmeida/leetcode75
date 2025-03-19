package info.sandroalmeida.leetcode150review;

public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    System.out.println(minSubArrayLen(5, new int[]{1,4,4}));
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int minLength = nums.length + 1;
    int currentSum = 0;
    int left = 0, right = 0;

    while(right < nums.length) {
      currentSum += nums[right];
      while(currentSum >= target) {
        minLength = Math.min(right - left + 1, minLength);
        currentSum -= nums[left];
        left++;
      }
      right++;
    }
    return minLength == nums.length + 1 ? 0 : minLength;
  }
}
