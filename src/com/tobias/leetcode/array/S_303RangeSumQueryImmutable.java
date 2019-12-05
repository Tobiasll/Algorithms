package com.tobias.leetcode.array;


/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class S_303RangeSumQueryImmutable {

  private int[] nums;

  public S_303RangeSumQueryImmutable(int[] nums) {
    this.nums = nums;
  }

  public int sumRange(int i, int j) {
    int sum = 0;
    for (; i < j; i++) {
      sum += nums[i];
    }
    return sum;
  }


}
