package com.tobias.leetcode.other;


import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class S_264UglyNumberII {



  public int nthUglyNumber(int n) {
    int[] dp = new int[n];
    dp[0] = 1;
    int two = 0, three = 0, five = 0;
    for (int i = 1; i < n; i++) {
      dp[i] = Math.min(dp[two] * 2, Math.min(dp[three] * 3, dp[five] * 5));
      if (dp[i] == dp[two] * 2) {
        two++;
      }
      if (dp[i] == dp[three] * 3) {
        three++;
      }
      if (dp[i] == dp[five] * 5) {
        five++;
      }
    }
    return dp[n - 1];
  }

  public int nthUglyNumberByPriorityQueue(int n) {
    if (n == 1) {
      return 1;
    }
    PriorityQueue<Long> pq = new PriorityQueue<>();
    pq.add(1L);
    for (int i = 1; i < n; i++) {
      long tempNum = pq.poll();
      while (!pq.isEmpty() && tempNum == pq.peek()) {
        tempNum = pq.poll();
      }
      pq.add(tempNum * 2);
      pq.add(tempNum * 3);
      pq.add(tempNum * 5);
    }
    return pq.poll().intValue();
  }

  /**
   * Time Limit Exceeded
   */
  public int nthUglyNumber1(int n) {
    int firstNums = 0;
    int count = 0;
    int num = 0;
    while (count != n) {
      int tempNum = num;
      for (int i = 2; i < 6 && tempNum > 0; i++) {
        while (tempNum % i == 0) {
          tempNum /= i;
        }
      }
      if (tempNum == 1) {
        firstNums = num;
        count++;
      }
      num++;
    }

    return firstNums;
  }

  public static void main(String[] args) {
    S_264UglyNumberII uglyNumberII = new S_264UglyNumberII();
    for (int i = 0; i <= 1690; i++) {
      System.out.print(uglyNumberII.nthUglyNumber(19));
      System.out.print(" , ");

    }

  }
}
