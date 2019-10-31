package com.tobias.leetcode.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique
 * permutations.
 *
 * Example:
 *
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 */
public class PermutationsII47 {

  public List<List<Integer>> permuteUniqueByChange(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    upset(result, nums, 0);
    return result;
  }

  private void upset(List<List<Integer>> result, int[] nums, int begin) {
    if (begin == nums.length) {
      List<Integer> insideList = new ArrayList<>(nums.length);
      for (int num : nums) {
        insideList.add(num);
      }
      result.add(insideList);
    } else {
      Set<Integer> set = new HashSet<>();
      for (int i = begin; i < nums.length; i++) {
        if (set.contains(nums[i])) {
          continue;
        }
        set.add(nums[i]);
        swap(nums, begin, i);
        upset(result, nums, begin + 1);
        swap(nums, begin, i);

      }
    }

  }

  private void swap(int[] nums, int i, int begin) {
    int temp = nums[i];
    nums[i] = nums[begin];
    nums[begin] = temp;
  }

  public List<List<Integer>> permuteUniqueByBacktrack(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(result, new ArrayList<>(), nums);
    return result;
  }

  private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      result.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == Integer.MIN_VALUE) {
          continue;
        }
        if (i > 0 && nums[i - 1] != Integer.MIN_VALUE && nums[i - 1] == nums[i]) {
          continue;
        }
        tempList.add(nums[i]);
        int temp = nums[i];
        nums[i] = Integer.MIN_VALUE;
        backtrack(result, tempList, nums);
        nums[i] = temp;
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public List<List<Integer>> permuteUniqueByForeach(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(Collections.singletonList(nums[0]));
    for (int i = 1; i < nums.length; i++) {
      int resultSize = result.size();
      for (int j = 0; j < resultSize; j++) {
        List<Integer> list = result.get(j);
        for (int k = 0; k <= i; k++) {
          if (i < k && nums[i] == list.get(k)) {
            continue;
          }
          List<Integer> insideList = new ArrayList<>(list);
          insideList.add(k, nums[i]);
          result.add(insideList);
        }

      }
      if (resultSize > 0) {
        result.subList(0, resultSize).clear();
      }
    }
    return new CombinationSum39().removeDuplicate(result);
  }

  public static void main(String[] args) {
    PermutationsII47 permutationsII47 = new PermutationsII47();
    List<List<Integer>> list = permutationsII47.permuteUniqueByChange(new int[]{1, 1, 2});
    for (List<Integer> integers : list) {
      System.out.println(integers);
    }
  }

}
