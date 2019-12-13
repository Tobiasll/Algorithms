package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class S_137SingleNumberII {

  public int singleNumber(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Integer key : map.keySet()) {
      if (map.get(key) == 1) {
        return key;
      }
    }

    return 0;
  }


  public static void main(String[] args) {
    S_137SingleNumberII singleNumberII = new S_137SingleNumberII();
    System.out.println(singleNumberII.singleNumber(new int[]{0,1,0,1,0,1,99}));
  }
}
