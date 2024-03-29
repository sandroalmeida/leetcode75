package info.sandroalmeida.leetcode75.binary;

/**
 * 371. Sum of Two Integers
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 * Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 * Input: a = 2, b = 3
 * Output: 5
 * */
public class SumWithoutPlusOperator {

    public static int getSum(int a, int b) {
        int c;
        while(b !=0 ) {
            c = (a&b);
            a = a ^ b;
            b = (c)<<1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(2, 9));
    }
}
