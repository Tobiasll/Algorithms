package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets
 * (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2] Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */
public class SubsetsII90 {


  /**
   * 位计算复制答案，dug仍然看不懂~~~///(^v^)\\\~~~，明天继续debug
   */
  public List<List<Integer>> subsetsWithDup(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> lists = new ArrayList<>();
    int subsetNum = 1 << num.length;
    for (int i = 0; i < subsetNum; i++) {
      List<Integer> list = new ArrayList<>();
      boolean illegal = false;
      for (int j = 0; j < num.length; j++) {
        //当前位是 1
        if ((i >> j & 1) == 1) {
          //当前是重复数字，并且前一位是 0，跳过这种情况
          if (j > 0 && num[j] == num[j - 1] && (i >> (j - 1) & 1) == 0) {
            illegal = true;
            break;
          } else {
            list.add(num[j]);
          }
        }
      }
      if (!illegal) {
        lists.add(list);
      }

    }
    return lists;
  }


  public List<List<Integer>> subsetsWithDupByForeach2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    result.add(new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
        count++;
        i++;
      }
      List<List<Integer>> tempList = new ArrayList<>();
      for (List<Integer> list : result) {
        List<Integer> insideList = new ArrayList<>(list);
        for (int c = 0; c <= count; c++) {
          insideList.add(nums[i]);
          tempList.add(new ArrayList<>(insideList));
        }
      }
      result.addAll(tempList);
    }

    return result;
  }

  public List<List<Integer>> subsetsWithDupByForeach1(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    result.add(new ArrayList<>());
    int newSolveValue = result.size();
    for (int i = 0; i < nums.length; i++) {
      List<List<Integer>> tempList = new ArrayList<>();
      for (int j = 0; j < result.size(); j++) {
        if (i > 0 && nums[i] == nums[i - 1] && j < newSolveValue) {
          continue;
        }
        List<Integer> insideList = new ArrayList<>(result.get(j));
        insideList.add(nums[i]);
        tempList.add(insideList);
      }
      newSolveValue = result.size();
      result.addAll(tempList);
    }
    return result;
  }

  public List<List<Integer>> subsetsWithDupByBacktrack(int[] nums) {
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
//    List<List<Integer>> list = subsetsII90.subsetsWithDupByForeach2(new int[]{4,4,4,1,4});
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }
  }
}
