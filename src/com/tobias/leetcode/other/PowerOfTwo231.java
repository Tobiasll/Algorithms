package com.tobias.leetcode.other;


/**
 *Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class PowerOfTwo231 {

  public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
  }

  public boolean isPowerOfTwo3(int n) {
    if (n == 0) {
      return false;
    }
    return n == 1 || n % 2 == 0 && isPowerOfTwo(n / 2);
  }

    public boolean isPowerOfTwo2(int n) {
    if (n == 0) {
      return false;
    }
    while (n % 2 == 0) {
      n /= 2;
    }
    return n == 1;
  }


  public boolean isPowerOfTwo1(int n) {
    if (n == 1) {
      return true;
    }
    int num = 0;
    for (int i = 0; num >= 0; i++) {
      num = 2 << i;
      if (num == n) {
        return true;
    }
      if (num > n) {
        break;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    PowerOfTwo231 powerOfTwo231 = new PowerOfTwo231();
    System.out.println(powerOfTwo231.isPowerOfTwo1(1));
    System.out.println(powerOfTwo231.isPowerOfTwo1(16));
    System.out.println(powerOfTwo231.isPowerOfTwo1(218));
    System.out.println(powerOfTwo231.isPowerOfTwo1(256));
    System.out.println(powerOfTwo231.isPowerOfTwo1(0));
    System.out.println(powerOfTwo231.isPowerOfTwo1(1073741825));

  }
}
