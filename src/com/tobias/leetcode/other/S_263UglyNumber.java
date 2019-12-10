package com.tobias.leetcode.other;


/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 *
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 *
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
public class S_263UglyNumber {

  public boolean isUgly(int num) {
    int[] primeFactors = new int[]{2, 3, 5};

    while (num > 0) {
      boolean flag = true;
      for (int factor : primeFactors) {
        while (num % factor == 0) {
          num /= factor;
          flag = false;
        }
      }
      if (flag) {
        break;
      }
    }
    return num == 1;
  }

  public static void main(String[] args) {
    S_263UglyNumber uglyNumber = new S_263UglyNumber();
    for (int i = 0; i < 1000; i++) {
      if (uglyNumber.isUgly(i)) {
        System.out.println(i);
      }
    }
  }
}
