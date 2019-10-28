package com.tobias.leetcode.array;


/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray53 {


  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int max = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      max = Math.max(max, num);
      for (int j = i + 1; j < nums.length; j++) {
        num += nums[j];
        max = Math.max(max, num);
      }
    }

    return max;
  }

  public int findGreatestSumOfSubArray(int[] arr) {
    // 参数校验
    if (arr == null || arr.length < 1) {
      throw new IllegalArgumentException("Array must contain an element");
    }

    // 记录最大的子数组和，开始时是最小的整数
    int max = Integer.MIN_VALUE;
    // 当前的和
    int curMax = 0;
    // 数组遍历
    for (int i : arr) {
      // 如果当前和小于等于0，就重新设置当前和
      if (curMax <= 0) {
        curMax = i;
      }
      // 如果当前和大于0，累加当前和
      else {
        curMax += i;
      }

      // 更新记录到的最在的子数组和
      if (max < curMax) {
        max = curMax;
      }
    }


    return max;
  }


  public static void main(String[] args) {
    MaximumSubarray53 maximumSubarray53 = new MaximumSubarray53();
    System.out.println(maximumSubarray53.findGreatestSumOfSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    System.out.println(maximumSubarray53.findGreatestSumOfSubArray(new int[]{-2, 1}));

  }


}
