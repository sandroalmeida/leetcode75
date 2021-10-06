package info.sandroalmeida.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Constraints:
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        for(int[] next: intervals){
            int currentEnd = current[1];
            int nextStart = next[0];
            int nextEnd = next[1];
            if(currentEnd >= nextStart){
                current[1] = Math.max(currentEnd, nextEnd);
            } else{
              current = next;
              result.add(current);
            }
        }
        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] input_1 = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] result_1 = merge(input_1);
    }
}
