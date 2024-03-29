package info.sandroalmeida.leetcode75.random_exercises;

/**
 * Given a binary array nums and an integer k,
 * return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Constraints:
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 * 0 <= k <= nums.length*/
public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int max = 0, i = 0, j = 0, extra = 0;
        while(i < nums.length && j < nums.length){
            if(nums[j] != 1){
                i = j;
            } else{
                extra++;
                int currentWindows = j - i;
                if(currentWindows > max) {
                    max = currentWindows;
                }
            }
            j++;
        }
        extra -= max;
        return max + Math.min(extra, k);
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
