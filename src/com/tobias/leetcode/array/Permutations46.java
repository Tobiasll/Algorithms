package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations46 {

  public List<List<Integer>> permute(int[] nums) {
//    return permuteByRecursion(nums, nums.length - 1);
//    return permuteByForeach(nums);
    return permuteByChange(nums);
  }

  int count ;

  private List<List<Integer>> permuteByChange(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    upset(result, 0, nums);
    return result;
  }

  private void upset(List<List<Integer>> result, int begin, int[] nums) {
    if (begin == nums.length) {
      List<Integer> insideList = new ArrayList<>(nums.length);
      for (int num : nums) {
        insideList.add(num);
      }
      result.add(insideList);
    } else {
      for (int i = begin; i < nums.length; i++) {
        swap(nums, i, begin);
        upset(result, begin + 1, nums);
        swap(nums, i, begin);
      }
    }

  }

  private void swap(int[] nums, int i, int begin) {
    int temp = nums[i];
    nums[i] = nums[begin];
    nums[begin] = temp;
  }

  private List<List<Integer>> permuteByBacktrack(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int num : nums) {
        count++;
        if (tempList.contains(num)) {
          continue;
        }
        tempList.add(num);
        backtrack(result, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  private List<List<Integer>> permuteByForeach(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    result.add(Collections.singletonList(nums[0]));
    for (int i = 1; i < nums.length; i++) {
      insertNumToList(nums, result, i);
    }

    return result;
  }

  private void insertNumToList(int[] nums, List<List<Integer>> result, int i) {
    int resultSize = result.size();
    for (int j = 0; j < resultSize; j++) {
      for (int k = 0; k <= i; k++) {
        List<Integer> insideList = new ArrayList<>(result.get(j));
        insideList.add(k, nums[i]);
        result.add(insideList);
      }
    }
    if (resultSize > 0) {
      result.subList(0, resultSize).clear();
    }
  }


  private List<List<Integer>> permuteByRecursion(int[] nums, int end) {
    if (end == 0) {
      List<List<Integer>> result = new ArrayList<>();
      List<Integer> insideList = new ArrayList<>();
      insideList.add(nums[0]);
      result.add(insideList);
      return result;
    }
    List<List<Integer>> result = permuteByRecursion(nums, end - 1);
    insertNumToList(nums, result, end);
    return result;
  }

  public static void main(String[] args) {
    Permutations46 permutations46 = new Permutations46();
    List<List<Integer>> permute = permutations46.permuteByForeach(new int[]{1, 2, 3});
    for (List<Integer> list : permute) {
      System.out.println(list);
    }
    System.out.println(permutations46.count);
  }

}
