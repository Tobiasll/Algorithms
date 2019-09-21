package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray189 {

  public void rotateByReverse(int[] nums, int k) {
    k %= nums.length;
    revers(nums, 0, nums.length - 1);
    revers(nums, 0, k - 1);
    revers(nums, k, nums.length - 1);
  }

  private void revers(int[] nums, int i, int j) {
    while (i < j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
    System.out.println(Arrays.toString(nums));
  }


    public void rotate(int[] nums, int k) {
    for (int i = 0; i < k; i++) {
      int temp = nums[nums.length - 1];
      if (nums.length - 1 >= 0)
        System.arraycopy(nums, 0, nums, 1, nums.length - 1);
      nums[0] = temp;
    }
  }

  public static void main(String[] args) {
    RotateArray189 rotateArray189 = new RotateArray189();
    int[] nums = new int[]{1,2,3,4,5,6,7};
    rotateArray189.rotateByReverse(nums, 3);
    System.out.println(Arrays.toString(nums));
  }

}
