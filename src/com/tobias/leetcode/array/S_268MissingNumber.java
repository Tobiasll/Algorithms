package com.tobias.leetcode.array;


import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * Example 3:
 *
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * Example 4:
 *
 * Input: nums = [0]
 * Output: 1
 * Explanation: n = 1 since there is 1 number, so all numbers are in the range [0,1]. 1 is the missing number in the range since it does not appear in nums.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * 0 <= nums[i] <= n
 * All the numbers of nums are unique.
 */
public class S_268MissingNumber {

    public int missingNumber(int[] nums) {
        int diff = 0;

        for (int i = 0; i < nums.length; i++) {
            diff += ((i + 1) - nums[i]);
        }

        return diff;
    }


    /**
     * Runtime: 3 ms, faster than 28.60% of Java online submissions for Missing Number.
     * Memory Usage: 39.5 MB, less than 33.38% of Java online submissions for Missing Number.
     */
    public int missingNumberByUseSet(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        Set<Integer> numSet = new HashSet<>(nums.length);

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            numSet.add(num);
        }

        for (int num : nums) {
            if (!numSet.contains(max - num)) {
                return max - num;
            }
        }

        return max - min >= nums.length ? min + 1 : max + 1;
    }

    public static void main(String[] args) {
        S_268MissingNumber missingNumber = new S_268MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[]{0, 2}));
        System.out.println(missingNumber.missingNumber(new int[]{3,0,1}));
        System.out.println(missingNumber.missingNumber(new int[]{0,1}));
        System.out.println(missingNumber.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber.missingNumber(new int[]{0}));
    }
}
