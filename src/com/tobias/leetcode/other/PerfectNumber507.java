package com.tobias.leetcode.other;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive
 * divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false
 * when it is not. Example: Input: 28 Output: True Explanation: 28 = 1 + 2 + 4 + 7 + 14
 */
public class PerfectNumber507 {



  public boolean checkPerfectNumber(int num) {
    int sum = 1;
    for (int i = 2; i * i < num; i++) {
      if (num % i == 0) {
        sum = sum + i + num / i;
      }
    }


    return sum == num && num != 1;
  }

  public boolean checkPerfectNumber1(int num) {
    int sum = 1;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0) {
        if (i * i != num) {
          sum = sum + i + num / i;
        } else {
          sum = sum + i;
        }
      }
    }
    return sum == num && num != 1;

  }

  public static void main(String[] args) {
    PerfectNumber507 perfectNumber507 = new PerfectNumber507();
    System.out.println(perfectNumber507.checkPerfectNumber(28));
  }

}
