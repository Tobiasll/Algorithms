package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and
 * rob house 5 (money = 1). Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber198 {

  public int robByDp(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int pre1 = 0;
    int pre2 = 0;
    for (int num : nums) {
      int temp = pre1;
      pre1 = Math.max(pre2 + num, pre1);
      pre2 = temp;
    }
    return pre1;
  }

  public int robByDpArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currentHourseValue = nums[i];
      dp[i + 1] = Math.max(dp[i - 1] + currentHourseValue, dp[i]);
    }

    return dp[nums.length];
  }

  public int robByRecursiveAndMapMemo(int[] nums) {
    Map<Integer, Integer> memo = new HashMap<>();
    return robByRecursiveAndMapMemo(nums, memo, nums.length - 1);
  }

  private int robByRecursiveAndMapMemo(int[] nums, Map<Integer, Integer> memo, int i) {
    if (i < 0) {
      return 0;
    }
    if (memo.containsKey(i)) {
      return memo.get(i);
    }
    int result = Math.max(robByRecursiveAndMapMemo(nums, memo, i - 2) + nums[i],
        robByRecursiveAndMapMemo(nums, memo, i - 1));
    memo.put(i, result);
    return result;
  }


  private int robByRecursiveAndArrayMemo(int[] nums) {
    int[] memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return robByRecursiveAndArrayMemo(nums, memo, nums.length - 1);
  }

  public int robByRecursiveAndArrayMemo(int[] nums, int[] memo, int i) {
    if (i < 0) {
      return 0;
    }
    if (memo[i] >= 0) {
      return memo[i];
    }
    int result = Math.max(robByRecursiveAndArrayMemo(nums, memo, i - 2) + nums[i],
        robByRecursiveAndArrayMemo(nums, memo, i - 1));
    memo[i] = result;
    return result;
  }

  public int robByRecuRecursive(int[] nums) {
    return robByRecuRecursive(nums, nums.length - 1);
  }

  private int robByRecuRecursive(int[] nums, int i) {
    if (i < 0) {
      return 0;
    }
    return Math.max(robByRecuRecursive(nums, i - 2) + nums[i], robByRecuRecursive(nums, i - 1));
  }

  public static void main(String[] args) {
    HouseRobber198 houseRobber198 = new HouseRobber198();
    System.out.println(houseRobber198.robByDp(new int[]{1, 2, 3, 1}));
    System.out.println(houseRobber198.robByDp(new int[]{2, 7, 9, 3, 1}));
    System.out.println(houseRobber198.robByDp(new int[]{2, 1, 1, 2}));
    System.out.println(houseRobber198.robByDpArray(new int[]{4, 1, 2, 7, 5, 3, 1}));
  }
}
