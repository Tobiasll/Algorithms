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
    System.out.println(uglyNumberII.nthUglyNumber(19));
  }
}
