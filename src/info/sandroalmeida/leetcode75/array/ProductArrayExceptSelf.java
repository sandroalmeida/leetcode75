package info.sandroalmeida.leetcode75.array;

/**
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 * */
public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] result = new int[nums.length];
        int zeros = 0;

        // counting zeros
        for(int i: nums){
            if(i == 0)
                zeros++;
        }

        if(zeros > 1)
            return new int[nums.length];

        // calculating total prod
        for (int num : nums) {
            if (num != 0)
                prod *= num;
        }

        // calculating result with 1 zero or any zeros
        for(int i = 0; i < nums.length; i++){
            if(zeros == 0)
                result[i] = prod / nums[i];
            else if(zeros > 0 && nums[i] == 0)
                result[i] = prod;
            else
                result[i] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums_1 = new int[]{ 1, 2, 3, 4 };
        int[] result_1 = productExceptSelf(nums_1);
        for(int i: result_1)
            System.out.print(i + " ");

        System.out.println("");

        int[] nums_2 = new int[]{ -1, 1, 0, -3, 3 };
        int[] result_2 = productExceptSelf(nums_2);
        for(int i: result_2)
            System.out.print(i + " ");
    }
}
