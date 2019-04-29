package com.tobias.leetcode.binary_search;

import java.util.Arrays;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII167 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 8, 9 ,11, 15}, 9)));
  }

  private static int[] twoSum(int[] numbers, int target) {
    int[] indice = new int[2];
    if (numbers == null || numbers.length < 2) return indice;
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      int v = numbers[left] + numbers[right];
      if (v == target) {
        indice[0] = left + 1;
        indice[1] = right + 1;
        break;
      } else if (v > target) {
        right --;
      } else {
        left ++;
      }
    }
    return indice;
  }

}
