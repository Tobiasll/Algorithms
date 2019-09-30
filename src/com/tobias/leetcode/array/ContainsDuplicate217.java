package com.tobias.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate217 {

  public boolean containsDuplicate(int[] nums) {

    /*
     * 	Wrong Answer and Memory Limit Exceeded
     */
    byte[] mark = new byte[160000000];
    for (int i : nums) {
      if (i < 0) {
        i = i * -1;
      }
      int j = i/8;
      int k = i%8;
      int check = 1<<k;
      if ((mark[j] & check) != 0) {
        return true;
      }
      mark[j]|=check;
    }
    return false;
  }


  /**
   * Runtime: 5 ms, faster than 96.78% of Java online submissions for Contains Duplicate.
   * Memory Usage: 42 MB, less than 98.28% of Java online submissions for Contains Duplicate.
   */
  public boolean containsDuplicateOrderArray(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  /**
   * Runtime: 9 ms, faster than 60.78% of Java online submissions for Contains Duplicate.
   * Memory Usage: 43 MB, less than  80.28% of Java online submissions for Contains Duplicate.
   */
  public boolean containsDuplicateBySet(int[] nums) {
    Set<Integer> map = new HashSet<>();
    for (int num : nums) {
      if (map.contains(num)) {
        return true;
      }
      map.add(num);
    }
    return false;
  }

  public static void main(String[] args) {
    ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
    System.out.println(containsDuplicate217.containsDuplicate(new int[]{-1200000005,-1200000005}));
  }
}
