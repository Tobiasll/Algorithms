package com.tobias.leetcode.other;


/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class S_258AddDigits {

  public int addDigits(int num) {
    if (num < 10) {
      return num;
    }
    int sum = 0;
    while (num >= 10) {
      while (num != 0) {
        sum += num % 10;
        num /= 10;
      }
      num = sum;
      if (num < 10) {
        break;
      }
      sum = 0;
    }
    return sum;
  }

  public static void main(String[] args) {
    S_258AddDigits addDigits = new S_258AddDigits();
    System.out.println(addDigits.addDigits(38));
  }

}
