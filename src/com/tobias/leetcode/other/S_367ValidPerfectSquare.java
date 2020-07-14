package com.tobias.leetcode.other;


/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Follow up: Do not use any built-in library function such as sqrt.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 16
 * Output: true
 * Example 2:
 *
 * Input: num = 14
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= num <= 2^31 - 1
 */
public class S_367ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long height = num, low = 1, mid;

        while (low <= height) {
            mid = (height + low) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                height = mid;
            } else if (mid * mid < num) {
                low = mid;
            }
            if (height - low == 1) {
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        S_367ValidPerfectSquare validPerfectSquare = new S_367ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(808201));
        System.out.println(validPerfectSquare.isPerfectSquare(1));
        System.out.println(validPerfectSquare.isPerfectSquare(9));
        System.out.println(validPerfectSquare.isPerfectSquare(16));
        System.out.println(validPerfectSquare.isPerfectSquare(14));
        System.out.println(validPerfectSquare.isPerfectSquare(2147483647));
    }
}
