package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3] Output: 3 Example 2:
 *
 * Input: [2,2,1,1,1,2,2] Output: 2
 */
public class MajorityElement169 {

  public int majorityElementByMooreMajorityVote(int[] nums) {
    int result = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        result = nums[i];
        count++;
      } else if (result == nums[i]) {
        count++;
      } else {
        count--;
      }
    }
    return result;
  }

  /**
   * Runtime: 1 ms, faster than 99.95% of Java online submissions for Majority Element. Memory
   * Usage: 41.3 MB, less than 83.82% of Java online submissions for Majority Element
   */
  public int majorityElementBySoryArray(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  /**
   * Runtime: 1 ms, faster than 5.95% of Java online submissions for Majority Element. Memory Usage:
   * 41.3 MB, less than 70.82% of Java online submissions for Majority Element
   */
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;

    for (int num : nums) {
      map.merge(num, 1, (a, b) -> a + b);
      if (map.get(num) > nums.length / 2) {
        result = num;
        break;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    MajorityElement169 majorityElement169 = new MajorityElement169();
    System.out.println(majorityElement169.majorityElementByMooreMajorityVote(new int[]{3, 2, 3}));
    System.out.println(
        majorityElement169.majorityElementByMooreMajorityVote(new int[]{2, 2, 1, 1, 1, 2, 2}));
  }
}
