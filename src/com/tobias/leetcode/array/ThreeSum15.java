package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        int low = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
        while (low < hi) {
          if (nums[low] + nums[hi] == sum) {
            result.add(Arrays.asList(nums[i], nums[low], nums[hi]));
            while (low < hi && nums[low] == nums[low + 1]) {
              low++;
            }
            while (low < hi && nums[hi] == nums[hi - 1]) {
              hi--;
            }
            low++; hi--;
          } else if (nums[low] + nums[hi] < sum) {
            low++;
          } else {
            hi--;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ThreeSum15 threeSum15 = new ThreeSum15();
    List<List<Integer>> list = threeSum15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }

  }
}
