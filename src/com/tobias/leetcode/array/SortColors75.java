package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of
 * the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2]
 */
public class SortColors75 {


  public void sortColors(int[] nums) {
    int zeroIndex = 0;
    int twoIndex = nums.length - 1;
    // 这里一定要小于等于twoIndex,不可以使用nums,length,否则会出现中间的1会被处理导致1和2交换,结果不正确
    for (int i = 0; i <= twoIndex; i++) {
      if (nums[i] == 0) {
        int tempNum = nums[zeroIndex];
        nums[zeroIndex] = nums[i];
        nums[i] = tempNum;
        zeroIndex++;
      } else if (nums[i] == 2) {
        int tempNum = nums[twoIndex];
        nums[twoIndex] = nums[i];
        nums[i] = tempNum;
        twoIndex--;
        i--;
      }
    }
  }

  public void sortColorsByArray(int[] nums) {
    int[] count = new int[3];
    for (int i : nums) {
      count[i] += 1;
    }
    int index = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = index; j < count[i] + index; j++) {
        nums[j] = i;
      }
      index += count[i];
    }

  }


  public void sortColorsByMap(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }
    int index = 0;
    for (int i = 0; i < 3; i++) {
      if (map.get(i) != null) {
        for (int j = index; j < map.get(i) + index; j++) {
          nums[j] = i;
        }
        index += map.get(i);
      }
    }

  }

  public static void main(String[] args) {
    SortColors75 sortColors75 = new SortColors75();
    int[] nums = {2, 0, 2, 1, 1, 0};
//    int[] nums = {0};
    sortColors75.sortColorsByArray(nums);
    System.out.println(Arrays.toString(nums));
  }
}
