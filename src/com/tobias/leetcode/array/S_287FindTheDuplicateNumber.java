package com.tobias.leetcode.array;


/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one duplicate number in nums, return this duplicate number.
 *
 * Follow-ups:
 *
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem without modifying the array nums?
 * Can you solve the problem using only constant, O(1) extra space?
 * Can you solve the problem with runtime complexity less than O(n2)?
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [1,1]
 * Output: 1
 * Example 4:
 *
 * Input: nums = [1,1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 2 <= n <= 3 * 104
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class S_287FindTheDuplicateNumber {


    /**
     * Runtime: 271 ms, faster than 5.01% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 39.2 MB, less than 39.68% of Java online submissions for Find the Duplicate Number.
     * TODO optimizing
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        S_287FindTheDuplicateNumber findTheDuplicateNumber = new S_287FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,1}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,1,2}));
    }
}
