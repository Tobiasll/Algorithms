package com.tobias.leetcode.other;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2 Output: 2 Explanation: There are two ways to climb to the top. 1. 1 step + 1 step 2. 2
 * steps Example 2:
 *
 * Input: 3 Output: 3 Explanation: There are three ways to climb to the top. 1. 1 step + 1 step + 1
 * step 2. 1 step + 2 steps 3. 2 steps + 1 step 所以结果等于 1 = 1 , 2 = 1 + 1， n = 3 之后的结果等于 n
 * 的前一个的结果加上n的前前一个的结果 1 : 1 2 : 2 3 : 3 4 : 5 5 : 8 6 : 13 7 : 21 8 : 34 9 : 55
 */
public class ClimbingStairs70 {


  public int climbStairs(int n) {
    if (n <= 1) {
      return 1;
    }
    int[] a = new int[n + 1];
    a[0] = 1;
    a[1] = 1;
    for (int i = 2; i <= n; i++) {
      a[i] = a[i - 1] + a[i - 2];
    }
    return a[n];
  }

  public static void main(String[] args) {
    ClimbingStairs70 climbingStairs70 = new ClimbingStairs70();
    System.out.println(climbingStairs70.climbStairs(3));
    System.out.println(climbingStairs70.climbStairs(4));
    System.out.println(climbingStairs70.climbStairs(5));
    System.out.println(climbingStairs70.climbStairs(6));
    System.out.println(climbingStairs70.climbStairs(7));
    System.out.println(climbingStairs70.climbStairs(8));
    System.out.println(climbingStairs70.climbStairs(9));
  }
}
