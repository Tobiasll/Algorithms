package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII40 {

  public List<List<Integer>> combinationSum2ByDynamic(int[] candidates, int target) {
    List<List<List<Integer>>> opt = new ArrayList<>();
    Arrays.sort(candidates);
    for (int i = 0; i <= target; i++) {
      List<List<Integer>> temp = new ArrayList<>();
      opt.add(i, temp);
    }
    for (int i = 0; i < candidates.length; i++) {
      if (i > 0 && candidates[i] == candidates[i - 1]) {
        continue;
      }
      for (int sum = candidates[i]; sum <= target; sum++) {
        List<List<Integer>> optResult = opt.get(sum);
        List<List<Integer>> optSubResult = opt.get(sum - candidates[i]);
        if (optSubResult.size() == sum) {
          List<Integer> insideList = new ArrayList<>(1);
          insideList.add(candidates[i]);
          optResult.add(insideList);
        }
        if (optSubResult.size() > 0){
          for (List<Integer> insideList : optSubResult) {
            List<Integer> newInsideList = new ArrayList<>(insideList);
            newInsideList.add(candidates[i]);
            optResult.add(newInsideList);
          }
        }
      }
    }
    return remove(opt.get(target), candidates);
  }

    public List<List<Integer>> combinationSum2ByDynamicDuplicate(int[] candidates, int target) {
    List<List<List<Integer>>> opt = new ArrayList<>();
    Arrays.sort(candidates);

    for (int sum = 0; sum <= target; sum++) {
      List<List<Integer>> optResult = new ArrayList<>();
      for (int i = 0; i < candidates.length; i++) {
        if (i > 0 && candidates[i] == candidates[i - 1]) {
          continue;
        }
        if (sum == candidates[i]) {
          List<Integer> insideList = new ArrayList<>(1);
          insideList.add(candidates[i]);
          optResult.add(insideList);
        } else if (candidates[i] < sum) {
          List<List<Integer>> optSubResult = opt.get(sum - candidates[i]);
          for (List<Integer> list : optSubResult) {
            List<Integer> insideList = new ArrayList<>(list);
            insideList.add(candidates[i]);
            optResult.add(insideList);
          }
        } else {
          break;
        }
      }
      opt.add(sum, optResult);
    }
    return remove(new CombinationSum39().removeDuplicate(opt.get(target)), candidates);
  }



    public List<List<Integer>> combinationSum2ByBacktrack(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    // 排序后减少重复的子问题计算
    Arrays.sort(candidates);
    backtrack(result, new ArrayList<>(), candidates, target, 0);
    return new CombinationSum39().removeDuplicate(result);
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates,
      int remain, int start) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = start; i < candidates.length; i++) {
        // 出现重复情况直接跳过
        if (i > start && candidates[i] == candidates[i - 1]) {
          continue;
        }
        tempList.add(candidates[i]);
        // 和之前不同的是，不在出现start相同的情况，start会递增
        backtrack(result, tempList, candidates, remain - candidates[i], i + 1);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  // 过滤不满足答案的情况
  private List<List<Integer>> remove(List<List<Integer>> list, int[] candidates) {
    Map<Integer, Integer> candidateMap = new HashMap<>();
    List<List<Integer>> result = new ArrayList<>(list);
    for (int candidate : candidates) {
      Integer count = candidateMap.getOrDefault(candidate, 0);
   // 记录每个数字出现的次数
      candidateMap.put(candidate, ++count);
    }
    for (List<Integer> insideList : list) {
      Map<Integer, Integer> insideNumMap = new HashMap<>();
      for (int num : insideList) {
        // 记录每个 list 中数字出现的次数
        int count = insideNumMap.getOrDefault(num, 0);
        insideNumMap.put(num, ++count);
      }
      for (int num : insideList) {
        // 进行比较
        if (insideNumMap.get(num) > candidateMap.get(num)) {
          result.remove(insideList);
          break;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    CombinationSumII40 combinationSumII40 = new CombinationSumII40();
//    List<List<Integer>> list = combinationSumII40.combinationSum2ByDynamic(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//    List<List<Integer>> list = combinationSumII40.combinationSum2ByDynamicDuplicate(new int[]{1,2}, 4);
//    List<List<Integer>> list = combinationSumII40.combinationSum2ByDynamicDuplicate(new int[]{1,1, 1, 1, 1}, 9);
    List<List<Integer>> list = combinationSumII40.combinationSum2ByDynamic(new int[]{2, 3, 5}, 6);
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }
  }

}
