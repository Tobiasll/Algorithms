package com.tobias.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 *
 * Input: [4,3,2,7,8,2,3,1]
 *
 * Output: [5,6]
 */
public class FindAllNumbersDisappearedInAnArrays448 {

  public static void main(String[] args) {
    System.out.println(findDisappearedNumbersByStupid(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    System.out.println(findDisappearedNumbersByStupid(new int[]{1, 1}));
  }

  private static List<Integer> findDisappearedNumbersByGenius(int[] nums) {
    List<Integer> ret = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        ret.add(i + 1);
      }
    }

    return ret;
  }

  private static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < nums.length; i++) {
      nums[(nums[i] - 1) % n] += n;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= n) {
        res.add(i + 1);
      }
    }
    return res;
  }

  private static List<Integer> findDisappearedNumbersByStupid(int[] nums) {
    Arrays.sort(nums);
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] + 1 < nums[i + 1]  ) {
        while (nums[i] + 1 < nums[i + 1]) {
          nums[i] = nums[i] + 1;
          list.add(nums[i]);
        }
      }
    }

    return list;
  }
}
