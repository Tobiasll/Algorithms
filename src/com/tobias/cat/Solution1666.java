package com.tobias.cat;

/**
 * 给定 n 个整数和一个整数 k, 你可以从中选择 k 个整数，现在，要求你计算出 k 个数和为素数共有多少种方案。
 *
 * 样例
 * 样例 1:
 *
 * 输入：a=[3,7,12,19]，k=3
 * 输出：1
 * 解释：
 * There are 4 ways
 * 3+7+12=22　　3+7+19＝29　　7+12+19＝38　　3+12+19＝34
 * and only 29 is a prime.
 * 样例 2:
 *
 * 输入：a=[1,2,3], k=2
 * 输出：2
 * 解释：
 * There are 3 ways
 * 1 + 2 = 3         1 + 3 = 4      2 + 3 =5
 * and only 3 and 5 are primes.
 * 注意事项
 * n 不超过 1010
 * k 不超过 n
 */
public class Solution1666 {

  /**
   * @param a: the n numbers
   * @param k: the number of integers you can choose
   * @return: how many ways that the sum of the k integers is a prime number
   */
  public int getWays(int[] a, int k) {
    // Write your code here
    int count = 0;
    for (int i = 0; i < a.length; i++) {
      int index = i;
      long sum = a[index];
      for (int j = 1; j < k; j++) {
        if (index == a.length - 1) {
          index = 0;
        }
        sum += a[++index];
      }
      System.out.println(sum);
    }

    return count;
  }

  public static void main(String[] args) {
    Solution1666 solution1666 = new Solution1666();
    System.out.println(solution1666.getWays(new int[]{3,7,12,19}, 3));
    System.out.println(solution1666.getWays(new int[]{1,2,3}, 2));
  }
}
