package com.tobias.leetcode.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
 * one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */
public class S_645SetMismatch {


    /**
     * Runtime: 2 ms, faster than 84.31% of Java online submissions for Set Mismatch.
     * Memory Usage: 40 MB, less than 99.13% of Java online submissions for Set Mismatch.
     */
    public int[] findErrorNums(int[] nums) {
        int diff = 1;
        int duplicate = nums[0];

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                duplicate = Math.abs(num);
            }else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                diff = i + 1;
            }
        }
        System.out.println(Arrays.toString(nums));

        return new int[]{duplicate, diff};
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Set Mismatch.
     * Memory Usage: 40.8 MB, less than 43.57% of Java online submissions for Set Mismatch.
     */
    public int[] findErrorNumsUseArray(int[] nums) {
        int diff = 1;
        int duplicate = nums[0];
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                duplicate = i;
            } else if (arr[i] == 0) {
                diff = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        return new int[]{duplicate, diff};
    }

    /**
     * Runtime: 9 ms, faster than 41.83% of Java online submissions for Set Mismatch.
     * Memory Usage: 40.8 MB, less than 35.19% of Java online submissions for Set Mismatch.
     */
    public int[] findErrorNumsUseSet(int[] nums) {
        int diff = 1;
        int duplicate = nums[0];
        Set<Integer> allNum = new HashSet<>(nums.length);
        for (int num : nums) {
            if (allNum.contains(num)) {
                duplicate = num;
            } else {
                allNum.add(num);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!allNum.contains(i)) {
                diff = i;
            }
        }
        return new int[]{duplicate, diff};
    }

    public static void main(String[] args) {
        S_645SetMismatch setMismatch = new S_645SetMismatch();
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,1})));
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{3,2,2})));
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{2,2})));
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1,1,3,4})));

    }
}
