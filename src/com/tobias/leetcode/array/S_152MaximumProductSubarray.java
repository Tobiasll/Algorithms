package com.tobias.leetcode.array;


/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class S_152MaximumProductSubarray {

    public int maxProductWithViolence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            result = Math.max(sum, result);
            for (int j = i + 1; j < nums.length; j++) {
                sum *= nums[j];
                result = Math.max(sum, result);
                if (sum < result) {
                    break;
                }
            }

        }
        return result;
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int dpMax = nums[0];
        int dpMin = nums[0];

        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(temp * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }



    public static void main(String[] args) {
        S_152MaximumProductSubarray maximumProductSubarray = new S_152MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-4,-3,-2}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2,-3,7}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{2,3,-2,4}));
//        System.out.println(maximumProductSubarray.maxProduct(new int[]{0,2}));
//        System.out.println(maximumProductSubarray.maxProduct(new int[]{-3,0,1,-2}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-2,3,-4}));
    }
}
