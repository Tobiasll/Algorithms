package com.tobias.leetcode.array;


/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 *
 * Example 1:
 *
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 */
public class S_1295FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {

        int count = 0;
        for (int num : nums) {
            int digits = 0;
            while (num > 0) {
                digits++;
                num = num / 10;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        S_1295FindNumbersWithEvenNumberOfDigits findNumbersWithEvenNumberOfDigits = new S_1295FindNumbersWithEvenNumberOfDigits();
        System.out.println(findNumbersWithEvenNumberOfDigits.findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(findNumbersWithEvenNumberOfDigits.findNumbers(new int[]{555,901,482,1771}));
    }
}
