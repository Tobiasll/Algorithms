package com.tobias.leetcode.array;


import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement169 {



  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.merge(num, 1, (a, b) -> a + b);
    }

    int result = 0;
    int maxCount = 0;
    for (Integer key : map.keySet()) {
      if (map.get(key) > maxCount) {
        result = key;
        maxCount = map.get(key);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    MajorityElement169 majorityElement169 = new MajorityElement169();
    System.out.println(majorityElement169.majorityElement(new int[]{3,2,3}));
    System.out.println(majorityElement169.majorityElement(new int[]{2,2,1,1,1,2,2}));
  }
}
