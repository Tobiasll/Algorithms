package com.tobias.leetcode.array;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 */
public class S_154FindMinimumInRotatedSortedArrayII {


  public int findMin(int[] nums) {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result = Math.min(result, nums[i]);
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
