package com.tobias.leetcode.array;

public class MaxConsecutiveOnes485 {

  public static void main(String[] args) {
    System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
  }

  /**
   * 空间复杂度太高Memory Usage: 40.4 MB, less than 5.28% of Java online submissions for Max Consecutive Ones.
   */
  private static int findMaxConsecutiveOnes(int[] nums) {
    int count = 0, max = count;
    for (int num : nums) {
      count = num == 1 ? ++count  : 0;
      max = count > max ? count : max;
    }

    return max;
  }


}
