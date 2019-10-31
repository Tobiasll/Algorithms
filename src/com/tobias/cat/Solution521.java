package com.tobias.cat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 521. 去除重复元素 给一个整数数组，去除重复的元素。
 *
 * 你应该做这些事
 *
 * 1.在原数组上操作 2.将去除重复之后的元素放在数组的开头 3.返回去除重复元素之后的元素个数
 *
 * 样例 例1:
 *
 * 输入: nums = [1,3,1,4,4,2] 输出: [1,3,4,2,?,?] 4 解释: 1. 将重复的整数移动到 nums 的尾部 => nums = [1,3,4,2,?,?].
 * 2. 返回 nums 中唯一整数的数量  => 4. 事实上我们并不关心你把什么放在了 ? 处, 只关心没有重复整数的部分. 例2:
 *
 * 输入: nums = [1,2,3] 输出: [1,2,3] 3
 */
public class Solution521 {

  public static void main(String[] args) {
    System.out.println(deduplication(new int[]{1, 3, 1, 4, 4, 2}));
    System.out.println(deduplicationByr(new int[]{1, 3, 1, 4, 4, 2}));
    System.out.println(deduplication(new int[]{1, 2, 3}));
  }

  private static int deduplication(int[] nums) {
    // write your code here
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.contains(nums[i])) {
        set.add(nums[i]);
      } else {
        int j = i;
        while (j < nums.length && set.contains(nums[j])) {
          if (j + 1 < nums.length && !set.contains(nums[j + 1])) {
            int temp = nums[i];
            nums[i] = nums[j + 1];
            nums[j + 1] = temp;
            set.add(nums[i]);
            break;
          }
          j++;
        }
      }
    }

    System.out.println(Arrays.toString(nums));

    return set.size();
  }

  private static int deduplicationByr(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0, j = nums.length - 1;
    while (i <= j) {
      if (map.get(nums[i]) == null) {
        map.put(nums[i], 1);
      } else {
        map.put(nums[i], map.get(nums[i]) + 1);
      }
      if (map.get(nums[i]) > 1) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        j--;
      } else {
        i++;
      }
    }
    System.out.println(Arrays.toString(nums));
    return map.size();
  }


}
