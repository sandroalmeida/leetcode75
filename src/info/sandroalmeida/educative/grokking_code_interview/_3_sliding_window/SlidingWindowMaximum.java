package info.sandroalmeida.educative.grokking_code_interview._3_sliding_window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        if (nums.length == 1) return nums;
        int [] output = new int[nums.length - w + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();
        for (int i = 0; i < w; i++) {
            SlidingWindowMaximum.cleanUp(i, currentWindow, nums);
            currentWindow.add(i);
        }
        output[0] = nums[currentWindow.getFirst()];
        for (int i = w; i < nums.length; i++) {
            cleanUp(i, currentWindow, nums);
            if (!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - w)) {
                currentWindow.removeFirst();
            }
            currentWindow.add(i);
            output[i - w + 1] = nums[currentWindow.getFirst()];
        }
        return output;
    }

    public static void cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
        while (!currentWindow.isEmpty() && nums[i] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 5, 4, 1, 10};
        int size = 3;
        int[] result = findMaxSlidingWindow(nums, size);
        System.out.println(Arrays.toString(result));
    }
}
