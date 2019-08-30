package com.tobias.leetcode.array;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in
 * the right-hand column.
 *
 * 1,2,3 → 1,3,2 '
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 158476531
 */
public class NextPermutation31 {


  public void nextPermutation(int[] nums) {
    if (nums.length == 0) {
      return;
    }
    int i = nums.length - 2;

    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i < 0) {
      reverse(nums, 0);
      return;
    }

    int j = nums.length - 1;
    while (j >= 0  && nums[j] <= nums[i]) {
      j--;
    }

    swap(nums, i, j);
    reverse(nums, i+ 1);

  }

  private void reverse(int[] nums, int start) {
    for (int i = start, j = nums.length - 1; i < j; i++, j--) {
      swap(nums, i, j);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    NextPermutation31 nextPermutation31 = new NextPermutation31();
    nextPermutation31.nextPermutation(new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1});
    nextPermutation31.nextPermutation(new int[]{1, 2, 3});
    nextPermutation31.nextPermutation(new int[]{3, 2, 1});
    nextPermutation31.nextPermutation(new int[]{1, 1, 5});
  }
}
