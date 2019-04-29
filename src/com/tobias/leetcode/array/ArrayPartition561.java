package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */
public class ArrayPartition561 {

  public static void main(String[] args) {
    System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
  }

  private static int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = 0; i < nums.length; i += 2) {
      if (i + 1 < nums.length) {
        sum += Math.min(nums[i], nums[i + 1]);
      }
    }
    return sum;
  }
}
