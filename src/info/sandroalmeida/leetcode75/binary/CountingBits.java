package info.sandroalmeida.leetcode75.binary;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/
 *
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 *
 * Example 1:
 * Input: n = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 *
 * Example 2:
 * Input: n = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * Constraints:
 * 0 <= n <= 105
 *
 * Follow up:
 * It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 * */
public class CountingBits {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        while(n > 0){
            result[n] = hammingWeight(n);
            n--;
        }
        return result;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while(n!=0) {
            count += (n & 1);
            n = n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] result_1 = countBits(2);
        int[] result_2 = countBits(5);
    }
}
