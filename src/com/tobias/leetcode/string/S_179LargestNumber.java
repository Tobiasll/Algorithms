package com.tobias.leetcode.string;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * Example 3:
 *
 * Input: nums = [1]
 * Output: "1"
 * Example 4:
 *
 * Input: nums = [10]
 * Output: "10"
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class S_179LargestNumber {

    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i] + "";
        }

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if ("0".equals(str[0])) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        S_179LargestNumber largestNumber = new S_179LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber.largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber.largestNumber(new int[]{999999998,999999997,999999999}));
    }


}
