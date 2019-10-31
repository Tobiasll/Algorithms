package com.tobias.leetcode.array;

import java.util.HashMap;
import java.util.Map;


/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single
 * one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1] Output: 1 Example 2:
 *
 * Input: [4,1,2,1,2] Output: 4
 */
public class SingleNumber136 {


  /**
   * (4) ^ (1 ^ 1) ^ (2 ^ 2) = 4 ^ 0 ^ 0 = 4
   */
  public int singleNumberByExclusiveOR(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }

    return result;
  }

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      Integer count = map.getOrDefault(num, 0);
      map.put(num, count + 1);
    }
    for (Integer key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    SingleNumber136 singleNumber136 = new SingleNumber136();
    System.out.println(singleNumber136.singleNumber(new int[]{2, 2, 1}));
    System.out.println(singleNumber136.singleNumber(new int[]{4, 1, 2, 1, 2}));

  }
}
