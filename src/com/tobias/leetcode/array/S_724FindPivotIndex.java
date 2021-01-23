package com.tobias.leetcode.array;


/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 *
 *
 * Example 1:
 * 28 - 1   28 - 8  28 - 11 28 - 17
 * Input: nums = [1,7,3,6,5,6] 1 < 6 l++, 8 > 6 r++, 8 < 11 l++, 11 == 11 l++ == r++
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 *
 * Constraints:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class S_724FindPivotIndex {


    /**
     *
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - preSum - nums[i] == preSum) {
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }

    /**
     * error because has negative
     */
    public int pivotIndex1(int[] nums) {

        int left = 0, leftSum = nums[left++], right = nums.length - 1, rightSum = nums[right--];

        while (left <= right) {

            if (leftSum < rightSum) {
                leftSum += nums[left++];
            }
            if (leftSum > rightSum) {
                rightSum += nums[right--];
            }
            if (leftSum == rightSum) {
                if (left  == right ) {
                    return right;
                }
                leftSum += nums[left++];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        S_724FindPivotIndex findPivotIndex = new S_724FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{1, 2, 3}));
        System.out.println(findPivotIndex.pivotIndex(new int[]{3, 2, 3}));
    }
}
