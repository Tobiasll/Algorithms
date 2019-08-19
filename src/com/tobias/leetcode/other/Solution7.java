package com.tobias.leetcode.other;


/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123 Output: 321 Example 2:
 *
 * Input: -123 Output: -321 Example 3:
 *
 * Input: 120 Output: 21 Note: Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this
 * problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Solution7 {

  public static int reverse(int x) {
    int y = 0;
    for (; x != 0; x /= 10) {
      if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) {
        return 0;
      }
      y = 10 * y + x % 10;
    }
    return y;
  }


  public static void main(String[] args) {
    System.out.println(reverse(123));
    System.out.println(123 / 10);
    System.out.println(123 % 10);
    System.out.println(Integer.MAX_VALUE /  10);
    System.out.println(Integer.MIN_VALUE /  10);
  }
}
