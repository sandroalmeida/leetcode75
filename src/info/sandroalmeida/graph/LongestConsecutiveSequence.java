package info.sandroalmeida.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        int maxSeq = 0;
        Set<Integer> setNums = new HashSet<>();
        for(int n: nums)
            setNums.add(n);

        for(int n: nums){
            if(!setNums.contains(n - 1)){
                int currSeq = 0;
                while(setNums.contains(n)){
                    currSeq++;
                    n++;
                }
                maxSeq = Math.max(maxSeq, currSeq);
            }
        }
        return maxSeq;

    }

    public static void main(String[] args) {
        int[] nums_1 = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums_1));

        int[] nums_2 = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums_2));
    }

}
