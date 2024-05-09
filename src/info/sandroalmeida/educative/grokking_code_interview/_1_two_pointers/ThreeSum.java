package info.sandroalmeida.educative.grokking_code_interview._1_two_pointers;

import java.util.Arrays;

public class ThreeSum {

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int current = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int result = nums[start] + nums[end] + current;
                if(result == target) {
                    return true;
                } else if(result < target) {
                    start ++;
                } else {
                    end --;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4,5,-3};
        System.out.println(findSumOfThree(nums, -8));
    }
}
