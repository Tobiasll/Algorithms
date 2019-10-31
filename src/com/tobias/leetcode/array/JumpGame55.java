package com.tobias.leetcode.array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1, then 3 steps to the
 * last index. Example 2:
 *
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame55 {

  public boolean canJump(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (max < i) {
        return false;
      }
      max = Math.max(max, nums[i] + i);
    }
    return true;
  }

  public boolean canJump1(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0 && max <= i) {
        return false;
      }
      max = Math.max(max, nums[i] + i);
    }
    return true;
  }

  public boolean canJumpIsCanJumpZero(int[] nums) {
// 注意这里循环的便捷为小于nums.length - 1而不是num.length，否则会出现{0}会被处理，并且{2，0，0}中的第二个0被处理，
    // 由于 j + nums[j] > i 所以如果出现重复零的情况，最后面的那个零是可以不被处理的
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        boolean flag = false;
        int j = i - 1;
        while (j >= 0) {
          if (j + nums[j] > i) {
            flag = true;
            break;
          }
          j--;
        }
        if (!flag && nums.length != 1) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean canJumpByEager2(int[] nums) {
    int position = nums.length - 1;
    boolean isUpdate;
    while (position != 0) {
      isUpdate = false;
      for (int i = 0; i < position; i++) {
        if (nums[i] >= position - i) {
          position = i;
          isUpdate = true;
          break;
        }
      }
      // 3,2,1,0,4等情况使进不去if 条件语句修改position的位置，导致死循环，所有要使用标记来判断是否有被修改过position的值
      if (!isUpdate) {
        return false;
      }
    }

    return position == 0;
  }


  public boolean canJumpByEager1(int[] nums) {
    int end = 0;
    int maxPosition = 0;

    for (int i = 0; i < nums.length; i++) {
      if (end < i) {
        return false;
      }
      maxPosition = Math.max(maxPosition, nums[i] + i);
      if (end == i) {
        end = maxPosition;
      }
    }

    return nums.length - 1 <= maxPosition;
  }

  public static void main(String[] args) {
    JumpGame55 jumpGame55 = new JumpGame55();
    System.out.println(jumpGame55.canJump(new int[]{2, 3, 1, 1, 4}));
    System.out.println(jumpGame55.canJump(new int[]{3, 2, 1, 0, 4}));
    System.out.println(jumpGame55.canJump(new int[]{0}));
    System.out.println(jumpGame55.canJump(new int[]{2, 0, 0}));
    System.out.println(jumpGame55.canJump(new int[]{3, 0, 0, 0}));
  }
}
