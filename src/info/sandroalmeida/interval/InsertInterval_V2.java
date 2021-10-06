package info.sandroalmeida.interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals
 * still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * Example 3:
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 *
 * Example 4:
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 *
 * Example 5:
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 *
 * Constraints:
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 * */
public class InsertInterval_V2 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
        result.add(newInterval);

        // add all the rest
        while (i < intervals.length){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] input_1 = new int[][]{{1,3},{6,9}};
        int[] newInterval_1 = new int[]{2,5};
        int[][] result_1 = insert(input_1, newInterval_1);

        int[][] input_2 = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval_2 = new int[]{4,8};
        int[][] result_2 = insert(input_2, newInterval_2);

        int[][] input_3 = new int[][]{};
        int[] newInterval_3 = new int[]{5,7};
        int[][] result_3 = insert(input_3, newInterval_3);

        int[][] input_4 = new int[][]{{1,5}};
        int[] newInterval_4 = new int[]{2,3};
        int[][] result_4 = insert(input_4, newInterval_4);

        int[][] input_5 = new int[][]{{1,5}};
        int[] newInterval_5 = new int[]{6,8};
        int[][] result_5 = insert(input_5, newInterval_5);

        int[][] input_6 = new int[][]{{1,5},{6,8}};
        int[] newInterval_6 = new int[]{5,6};
        int[][] result_6 = insert(input_6, newInterval_6);

        int[][] input_7 = new int[][]{{2,5},{6,7},{8,9}};
        int[] newInterval_7 = new int[]{0,1};
        int[][] result_7 = insert(input_7, newInterval_7);
    }
}
