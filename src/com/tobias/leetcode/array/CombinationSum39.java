package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return result;
  }

  /**
   * 回溯法的整个过程
   * candidates = 2, 3, 5 target = 8
   * [2] remain = 6
   * [2, 2] remain = 4
   * [2, 2, 2] remain = 2
   * [2, 2, 2, 2] remain = 0 添加进结果集合
   * [2, 2, 2, 3] remain =  -1 超出目标值，直接返回结束此调用栈
   * [2, 2, 2, 5] remain =  -3 超出目标值，直接返回结束此调用栈
   * [2, 2, 3] remain =  7
   * [2, 2, 3, 3] remain = -2 超出目标值，直接返回结束此调用栈
   * [2, 2, 3, 5] remain = -4 超出目标值，直接返回结束此调用栈
   * [2, 2, 5] remain = -1 超出目标值，直接返回结束此调用栈
   * [2, 3] remain = 5
   * [2, 3, 3] remain = 0 添加进结果集合
   * [2, 3, 5] remain = -2 超出目标值，直接返回结束此调用栈
   * [2, 5] remain = 1
   * [2, 5, 5] remain = -4 超出目标值，直接返回结束此调用栈
   * [3] remain = 5
   * [3, 3] remain = 2
   * [3, 3, 3] remain = -1 超出目标值，直接返回结束此调用栈
   * [3, 3, 5] remain = -3 超出目标值，直接返回结束此调用栈
   * [3, 5] remain = 0 添加进结果集合
   * [5] remain = 3
   * [5, 5] remain = -2
   *
   */
  private void backtrack(List<List<Integer>> result, List<Integer> templist, int[] candidates,
      int remain, int start) {
    // 不断的递减所有结果，导致结果溢出，小于零，所有直接无须进行调用下去，直接结束当前调用栈
    if (remain < 0) {
      return;
    }
    // 每个可能性的值加起来刚刚等于目标值，所有将当前可能性的值加入结果集合
    if (remain == 0) {
      result.add(new ArrayList<>(templist));
    } else {
      // 不断的循环递归回溯所有可能出现的值，看所有值加起来是否可以等于目标值
      for (int i = start; i < candidates.length; i++) {
        // 一来直接就把当前值加进集合
        templist.add(candidates[i]);
        // 开始递归回溯，并把当前目标值去减去当前值，同时将当前索引再次进行递归回溯
        backtrack(result, templist, candidates, remain - candidates[i], i);
        // 找到了一个解或者 remain < 0 了，将当前数字移除，然后继续递增索引尝试
        templist.remove(templist.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    CombinationSum39 combinationSum39 = new CombinationSum39();
    List<List<Integer>> list = combinationSum39.combinationSum(new int[]{2, 3, 5}, 8);
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }

  }


}
