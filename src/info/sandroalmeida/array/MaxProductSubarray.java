package info.sandroalmeida.array;

/**
 * 152. Maximum Product Subarray
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * */
public class MaxProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int currentMin = 1, currentMax = 1;

        for(int i: nums){
            int tempMax = currentMax;
            currentMax = Math.max(Math.max(currentMax * i, currentMin * i), i);
            currentMin = Math.min(Math.min(tempMax * i, currentMin * i), i);
            maxProd = Math.max(currentMax, maxProd);
        }
        return maxProd;
    }

    public static void main(String[] args) {
        int[] nums_1 = new int[]{ 2, 3, -2, 4 };
        System.out.println(maxProduct(nums_1));

        int[] nums_2 = new int[]{ -2, 0, -1, -1 };
        System.out.println(maxProduct(nums_2));
    }
}
