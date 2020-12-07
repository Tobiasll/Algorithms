package com.tobias.leetcode.array;


import java.util.HashSet;
import java.util.Set;

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

    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int rabbit = nums[0];

        do {
            tortoise = nums[tortoise];
            rabbit = nums[nums[rabbit]];
        } while (tortoise != rabbit);

        tortoise = nums[0];
        while (rabbit != tortoise) {
            tortoise = nums[tortoise];
            rabbit = nums[rabbit];
        }
        return rabbit;
    }


    /**
     * Runtime: 271 ms, faster than 5.01% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 39.2 MB, less than 39.68% of Java online submissions for Find the Duplicate Number.
     * TODO optimizing
     */
    public int findDuplicateByForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public int findDuplicateBySet(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length - 1);
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        S_287FindTheDuplicateNumber findTheDuplicateNumber = new S_287FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,1}));
        System.out.println(findTheDuplicateNumber.findDuplicate(new int[]{1,1,2}));
    }
}
