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

  /**
   *  000 | []  | []
   *  001 | 001 | [1]
   *  010 | 020 | [2]
   *  011 | 021 | [1, 2]
   *  100 | 300 | [3]
   *  101 | 301 | [1, 3]
   *  110 | 320 | [2, 3]
   *  111 | 321 | [1, 2, 3]
    */
  public List<List<Integer>> subsetsByDisplacement(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    int bitNums = nums.length;
    int resultLength = 1 << bitNums; //执行 2 的 n 次方，拿到结果的个数8
    for (int i = 0; i < resultLength; i++) {
      List<Integer> insideList = new ArrayList<>();
      int count = 0; //记录当前对应数组的哪一位
      int iCopy = i; //用来移位
      while (iCopy != 0) {
        if ((iCopy & 1) == 1) { //判断当前位是否是 1,如果为1则添加进临时数组
          insideList.add(nums[count]);
        }
        count++;
        // 不断右移直到出现0也就是最左边都为0，结束循环 例如 i = 4 = 100 ，第一次循环后右移一位结果为10 = 2，
        // 然后继续位移一位结果为1 = 1 ，（4 - 2 - 1 - 0）继续位移就为0了，则退出循环
        iCopy = iCopy >> 1;//右移一位
      }
      result.add(insideList);

    }
    return result;
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
    List<List<Integer>> subsets = subsets78.subsetsByDisplacement(new int[]{1, 2, 3});
    for (List<Integer> subset : subsets) {
      System.out.println(subset);
    }
  }
}
