package info.sandroalmeida.leetcode75.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * */
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> numsMap = new HashMap<>();

        for(int num: nums)
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);

        for(Map.Entry<Integer, Integer> entry: numsMap.entrySet())
            maxHeap.add(entry);

        int[] result = new int[k];
        for(int i = 0; i < k; i++)
            result[i] = maxHeap.poll().getKey();

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{ 1, 1, 1, 2, 2, 3 };
        int[] result = topKFrequent(input, 3);
        for(int i: result)
            System.out.print(i + "-");
    }
}
