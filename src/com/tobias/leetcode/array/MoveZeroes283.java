package com.tobias.leetcode.array;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 *
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0]
 */
public class MoveZeroes283 {

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 3, 12};
    moveZeroes1(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void moveZeroes(int[] nums) {
    for (int k = 0, i = 0; i < nums.length; ++i) {
      if (nums[i] != 0 && nums[k] == 0) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k++] = temp;
      } else if (nums[k] != 0) {
        k = i;
      }
    }
  }


  private static void moveZeroes1(int[] nums) {
    int index = 0;
    for (int num : nums) {
      if (num != 0) {
        nums[index++] = num;
      }
    }

    for (int i = index; i < nums.length; i++) {
      nums[i] = 0;
    }

  }
}
