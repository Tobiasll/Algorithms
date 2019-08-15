package com.tobias.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TowSum1 {

  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          result[0] = i;
          result[1] = j;
          break;
        }
      }
    }

    return result;
  }

  public static int[] twoSumByMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if ( map.get(target - nums[i]) != null) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int[] ints = twoSumByMap(new int[]{3, 3}, 6);
//    int[] ints = twoSumByMap(new int[]{2, 7, 11, 15}, 9);
    System.out.println(Arrays.toString(ints));
  }
}
