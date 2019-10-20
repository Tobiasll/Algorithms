package com.tobias.leetcode.array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 */
public class JumpGameII45 {

  public int jump(int[] nums) {
    int end = 0;
    int maxPosition = 0;
    int step = 0;
    // 注意这里的边界是nums.length - 1；而不是num.length
    for (int i = 0; i < nums.length - 1; i++) {
      maxPosition = Math.max(maxPosition, nums[i] + i);
      if (end == i) {
        end = maxPosition;
        step ++;
      }

    }
    return step;
  }


    public int jump1(int[] nums) {
    int step = 0;
    int position = nums.length - 1;
    boolean isUpdate;

    while (position != 0) {
      isUpdate = false;
      for (int i = 0; i < position; i++) {
        if (nums[i] >= position - i) {
          step++;
          isUpdate = true;
          position = i;
          break;
        }
      }
      if (!isUpdate) {
        return step;
      }
    }
    return step;
  }

  public static void main(String[] args) {
    JumpGameII45 jumpGameII45 = new JumpGameII45();
    System.out.println(jumpGameII45.jump(new int[]{2,3,1,1,4}));
  }
}
