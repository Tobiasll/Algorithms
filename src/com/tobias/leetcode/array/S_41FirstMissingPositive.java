package com.tobias.leetcode.array;


/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class S_41FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
        int temp = nums[i];
        nums[i] = nums[nums[i] - 1];
        nums[temp - 1] = temp;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    S_41FirstMissingPositive firstMissingPositive = new S_41FirstMissingPositive();
    System.out.println(firstMissingPositive.firstMissingPositive(new int[]{1}));
  }
}
