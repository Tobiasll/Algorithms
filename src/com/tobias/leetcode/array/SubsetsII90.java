package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII90 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(nums, result, new ArrayList<>(), 0);
    return result;
  }

  private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> insideList,
      int startIndex) {
    result.add(new ArrayList<>(insideList));
    for (int i = startIndex; i < nums.length; i++) {
      // 和上一个数相等则跳过，但是i 必须大于startIndex 不能大于 0 ，否则后面相同的数每次都会被跳过，
      // 就变成只计算数组的数都是唯一的情况了,
      if (i > startIndex && nums[i] == nums[i - 1]) {
        continue;
      }
      insideList.add(nums[i]);
      backtrack(nums, result, insideList, i + 1);
      insideList.remove(insideList.size() - 1);
    }
  }

  public static void main(String[] args) {
    SubsetsII90 subsetsII90 = new SubsetsII90();
    List<List<Integer>> list = subsetsII90.subsetsWithDup(new int[]{1, 2, 2});
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }
  }
}
