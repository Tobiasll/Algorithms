package com.tobias.leetcode.array;


import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each
 * element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3] Output: [1,2,4] Explanation: The array represents the integer 123. Example 2:
 *
 * Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array represents the integer 4321.
 */
public class PlusOne66 {

  public int[] plusOneByForeach(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i] += 1;
        return digits;
      }
      digits[i] = 0;
    }
    if (digits[0] == 0) {
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      return result;
    }
    return digits;
  }


  public int[] plusOne(int[] digits) {
    return plusOne(digits, digits.length - 1);
  }

  private int[] plusOne(int[] digits, int index) {
    if (index < 0) {
      int[] result = new int[digits.length + 1];
      result[0] = 1;
      return result;
    }
    if (digits[index] < 9) {
      digits[index] += 1;
      return digits;
    }
    digits[index] = 0;
    return plusOne(digits, --index);
  }

  public static void main(String[] args) {
    PlusOne66 plusOne66 = new PlusOne66();
    System.out.println(Arrays.toString(plusOne66.plusOneByForeach(new int[]{1, 2, 3})));
    System.out.println(Arrays.toString(plusOne66.plusOneByForeach(new int[]{4, 3, 2, 1})));
    System.out.println(Arrays.toString(plusOne66.plusOneByForeach(new int[]{9, 9})));
  }

}
