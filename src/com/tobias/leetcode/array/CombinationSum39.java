package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

  public List<List<Integer>> combinationSumByDynamic(int[] candidates, int target) {
    // RunTime : 8 ms Memory ： 37.4 MB
    List<List<List<Integer>>> opt = new ArrayList<>();
    for (int i = 0; i <= target; i++) {
      List<List<Integer>> temp = new ArrayList<>();
      opt.add(i, temp);
    }

    for (int candidate : candidates) {
      for (int sum = candidate; sum <= target; sum++) {
        List<List<Integer>> optResult = opt.get(sum);
        // 计算获取到子问题集合
        List<List<Integer>> optSubResult = opt.get(sum - candidate);
        //刚开始 optResult 的大小是 0，所以单独考虑一下这种情况 即 sum = 3 = [[3]]的情况
        if (sum == candidate) {
          ArrayList<Integer> temp = new ArrayList<>();
          temp.add(candidate);
          optResult.add(temp);
        }

        //如果 ans.get(sum - nums[i])大小不等于 0，就可以按之前的想法更新了。
        //每个 ans_sub[j] 都加上 nums[i]
        if (optSubResult.size() > 0) {
          for (List<Integer> list : optSubResult) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            // 将当前值添加到子问题集合中
            temp.add(candidate);
            optResult.add(temp);
          }
        }
      }
    }
    return opt.get(target);
  }

    public List<List<Integer>> combinationSumByDynamicHasDuplicate(int[] candidates, int target) {
    // 动态规划将所有subproblem收集到集合中 RunTime : 82 ms Memory ： 43.8 MB
    List<List<List<Integer>>> opt = new ArrayList<>();
    // 排序数组，提升性能，这样可以提现结束循环
    Arrays.sort(candidates);
    // 计算目标之前的所有子问题结果
    for (int sum = 0; sum <= target; sum++) {
      // 当前目标结果集合
      List<List<Integer>> optResult = new ArrayList<>();
      // 遍历数组的值，
      for (int candidate : candidates) {
        // 如果当前值等于该子问题，因为数组是有序的，那么就说明，当前值直接命中目标，可以直接添加进结果集合， 例如 sum = 2 =  [[2]]/ sum = 3 = [[3]]
        if (candidate == sum) {
          List<Integer> insideList = new ArrayList<>(1);
          insideList.add(candidate);
          optResult.add(insideList);

        } else if (candidate < sum) {
          // 当前值小于目标值， 拿到当前目标 - 当前值的子问题集合
          // 例如 目标值 8 前7个结果集为
          //[]
          //[]
          //[[2]]
          //[[3]]
          //[[2, 2]]
          //[[3, 2], [2, 3], [5]]
          //[[2, 2, 2], [3, 3]]
          //[[3, 2, 2], [2, 3, 2], [5, 2], [2, 2, 3], [2, 5]]
          // 那么值为 2 时， 那么需要子问题等于6加上2才可以等于目标值8， 子问题6 = [[2, 2, 2], [3, 3]]， 遍历两个结果加上当前值2 = [2, 2, 2, 2], [3, 3, 2]
          // 那么值为 3 时， 那么需要子问题等于5加上3才可以等于目标值8， 子问题5 = [[3, 2], [2, 3], [5]]， 遍历三个结果加上当前值3 = [3, 2, 3], [2, 3, 3], [5, 3]
          // 那么值为 5 时， 那么需要子问题等于3加上5才可以等于目标值8， 子问题3 = [[3]]， 遍历一个结果加上当前值5 = [3, 5]
          // 最后目标值8的结果就为 上面三个的结果相加 = [[2, 2, 2, 2], [3, 3, 2], [3, 2, 3], [2, 3, 3], [5, 3], [3, 5]]
          List<List<Integer>> optSubResult = opt.get(sum - candidate);
          for (List<Integer> list : optSubResult) {
            List<Integer> insideList = new ArrayList<>(list);
            // 关键点，将当前值插入到拿到的子问题集合中
            insideList.add(candidate);
            optResult.add(insideList);
          }
        } else {
          // 溢出情况，当前值大于目标值
          break;
        }
      }
      // 将当前结果插入到当前子问题索引处
      opt.add(sum, optResult);
    }

    for (List<List<Integer>> list : opt) {
      System.out.println(list);
    }

    return removeDuplicate(opt.get(target));
  }


  public List<List<Integer>> combinationSumByBacktrack(int[] candidates, int target) {
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
   * Runtime ： 4 ms	Memery ： 36.7 MB
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

  public List<List<Integer>> removeDuplicate(List<List<Integer>> outList) {
    Map<String, String> map = new HashMap<>();
    for (List<Integer> list : outList) {
      // 出现当数组唯一的时候需要排序，如Permutations46题需要加上，而PermutationsII47数组不唯一的情况下则需要注释掉
      list.sort(Comparator.comparingInt(o -> o));
      StringBuilder key = new StringBuilder();
      for (int j = 0; j < list.size() - 1; j++) {
        key.append(list.get(j)).append(",");
      }
      key.append(list.get(list.size() - 1));
      map.put(key.toString(), "");
    }
    List<List<Integer>> result = new ArrayList<>();
    Set<String> keySet = map.keySet();
    for (String s : keySet) {
      String[] split = s.split(",");
      List<Integer> insideList = new ArrayList<>(split.length);
      for (String str : split) {
        insideList.add(Integer.parseInt(str));
      }
      result.add(insideList);
    }
    return result;
  }

  public static void main(String[] args) {
    CombinationSum39 combinationSum39 = new CombinationSum39();
    List<List<Integer>> list = combinationSum39.combinationSumByDynamic(new int[]{2, 3, 5}, 8);
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }

  }


}
