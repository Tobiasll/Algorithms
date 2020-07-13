package com.tobias.leetcode.array;

/**
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 *
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 */
public class S_713SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int result = 0, prod = 1, left = 0, right = 0;

        while (right < nums.length) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        S_713SubarrayProductLessThanK subarrayProductLessThanK = new S_713SubarrayProductLessThanK();
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

}
