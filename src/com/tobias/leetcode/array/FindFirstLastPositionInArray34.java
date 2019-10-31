package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position
 * of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 */
public class FindFirstLastPositionInArray34 {

  public int[] searchRange(int[] nums, int target) {
    int first = -1, last = -1, low = 0, hi = nums.length - 1;

    while (low <= hi) {
      int mid = (low + hi) / 2;
      if (nums[mid] < target) {
        low = mid + 1;
      } else if (nums[mid] > target) {
        hi = mid - 1;
      } else {
        first = mid;
        last = mid;
        break;
      }
    }

    if (first != -1) {
      for (int i = first - 1; i >= 0 && nums[i] == target; i--) {
        first = i;
      }
      for (int i = last + 1; i < nums.length && nums[i] == target; i++) {
        last = i;
      }

    }
    return new int[]{first, last};
  }

  public static void main(String[] args) {
    FindFirstLastPositionInArray34 findFirstLastPositionInArray34 = new FindFirstLastPositionInArray34();
    System.out.println(Arrays
        .toString(findFirstLastPositionInArray34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    System.out.println(Arrays
        .toString(findFirstLastPositionInArray34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    System.out
        .println(Arrays.toString(findFirstLastPositionInArray34.searchRange(new int[]{2, 2}, 2)));
    System.out
        .println(Arrays.toString(findFirstLastPositionInArray34.searchRange(new int[]{2}, 2)));
  }
}
