package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets1 (the power set).
 *
 * Note: The solution set must not contain duplicate subsets1.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets78 {


  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int bit_nums = nums.length;
    int ans_nums = 1 << bit_nums; //执行 2 的 n 次方
    for (int i = 0; i < ans_nums; i++) {
      List<Integer> tmp = new ArrayList<>();
      int count = 0; //记录当前对应数组的哪一位
      int i_copy = i; //用来移位
      while (i_copy != 0) {
        if ((i_copy & 1) == 1) { //判断当前位是否是 1
          tmp.add(nums[count]);
        }
        count++;
        i_copy = i_copy >> 1;//右移一位
      }
      ans.add(tmp);

    }
    return ans;
  }

  public List<List<Integer>> subsetsByBacktrack(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
  }

  private void backtrack(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
    result.add(new ArrayList<>(tempList));
    for (int i = start; i < nums.length; i++) {
      tempList.add(nums[i]);
      backtrack(nums, i + 1, tempList, result);
      tempList.remove(tempList.size() - 1);
    }
  }


  public List<List<Integer>> subsetsByForeach2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(Collections.emptyList());

    for (int num : nums) {
      int length = result.size();
      for (int i = 0; i < length; i++) {
        List<Integer> list = new ArrayList<>(result.get(i));
        list.add(num);
        result.add(list);
      }
    }
    return result;
  }

    public List<List<Integer>> subsetsByForeach1(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    result.add(Collections.emptyList());

    for (int i = 0; i < nums.length; i++) {
      int index = result.size();
      result.add(Collections.singletonList(nums[i]));
      for (int j = i + 1; j < nums.length; j++) {
        int length = result.size();
        for (int k = index; k < length; k++) {
          List<Integer> list = new ArrayList<>(result.get(k));
          list.add(nums[j]);
          result.add(list);
        }
      }
    }
    return result;
  }


  public static void main(String[] args) {
    Subsets78 subsets78 = new Subsets78();
    List<List<Integer>> subsets = subsets78.subsetsByBacktrack(new int[]{1, 2, 3});
    for (List<Integer> subset : subsets) {
//      System.out.println(subset);
    }
  }
}
