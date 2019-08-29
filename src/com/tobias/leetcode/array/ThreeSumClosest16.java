package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest16 {

  public int threeSumClosest(int[] nums, int target) {
    if (nums.length == 0) {
      return 0;
    }
    int result = nums[0] + nums[1] + nums[2];
    if (nums.length == 3) {
      return result;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int low = i + 1, hi = nums.length - 1;
      while (low < hi) {
        int sum = nums[low] + nums[hi] + nums[i];
        if (sum < target) {
           low++;
        } else {
          hi--;
        }
        if (Math.abs(sum - target) < Math.abs(result - target)) {
          result = sum;
        }
      }
    }
    return result;
  }


  public static void main(String[] args) {
    ThreeSumClosest16 threeSumClosest16 = new ThreeSumClosest16();
    System.out.println(threeSumClosest16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
  }
}
