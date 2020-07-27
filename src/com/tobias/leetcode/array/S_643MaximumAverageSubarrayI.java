package com.tobias.leetcode.array;


/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * Note:
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class S_643MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double result, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        result = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            result = Math.max(sum, result);
        }

        return result / k;
    }

    public double findMaxAverage1(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < k + i; j++) {
                sum += nums[j];
            }
            result = Math.max(sum, result);
        }

        return result / k;
    }

    public static void main(String[] args) {
        S_643MaximumAverageSubarrayI maximumAverageSubarrayI = new S_643MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverage(new int[]{-1}, 1));
        System.out.println(maximumAverageSubarrayI.findMaxAverage(new int[]{5}, 1));
        System.out.println(maximumAverageSubarrayI.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
